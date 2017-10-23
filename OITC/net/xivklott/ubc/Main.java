/*     */ package net.xivklott.ubc;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataOutput;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import java.io.PrintStream;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.xivklott.listener.AnnexListener;
/*     */ import net.xivklott.listener.DeathListener;
/*     */ import net.xivklott.listener.JoinListener;
/*     */ import net.xivklott.listener.PlayerListener;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.FireworkEffect;
/*     */ import org.bukkit.FireworkEffect.Builder;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Server.Spigot;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Firework;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Snowball;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.meta.FireworkMeta;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.plugin.messaging.Messenger;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class Main extends JavaPlugin implements Listener
/*     */ {
/*  34 */   public List<Player> players = new ArrayList();
/*  35 */   private List<Location> spawns = new ArrayList();
/*  36 */   ByteArrayDataOutput out = ByteStreams.newDataOutput();
/*     */   public SqlConnection sql;
/*     */   private States state;
/*     */   
/*     */   public void onEnable() {
/*  41 */     System.out.println("OITC Reloaded ON");
/*  42 */     setState(States.LOBBY);
/*  43 */     World world = Bukkit.getWorld("world");
/*  44 */     PluginManager pm = Bukkit.getServer().getPluginManager();
/*  45 */     this.sql = new SqlConnection("jdbc:mysql://", "localhost", "minigames", "root", "");
/*  46 */     this.sql.connection();
/*  47 */     pm.registerEvents(new JoinListener(this), this);
/*  48 */     pm.registerEvents(new PlayerListener(this), this);
/*  49 */     pm.registerEvents(new net.xivklott.listener.QuitListener(this), this);
/*  50 */     pm.registerEvents(new AnnexListener(this), this);
/*  51 */     pm.registerEvents(new DeathListener(this), this);
/*  52 */     getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
/*  53 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  54 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  55 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  56 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  57 */     super.onEnable();
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  61 */     super.onDisable();
/*     */   }
/*     */   
/*     */   public void Lobbytp(Player player) {
/*  65 */     this.out.writeUTF("Connect");
/*  66 */     this.out.writeUTF("lobby");
/*  67 */     player.sendPluginMessage(this, "BungeeCord", this.out.toByteArray());
/*     */   }
/*     */   
/*     */   public void setState(States state) {
/*  71 */     this.state = state;
/*     */   }
/*     */   
/*     */   public boolean isState(States state) {
/*  75 */     return this.state == state;
/*     */   }
/*     */   
/*     */   public List<Player> getPlayers() {
/*  79 */     return this.players;
/*     */   }
/*     */   
/*     */   public List<Location> getSpawns() {
/*  83 */     return this.spawns;
/*     */   }
/*     */   
/*     */   public void checkAlone() {
/*  87 */     if (isState(States.PLAYING)) {
/*  88 */       if (this.players.size() == 1) {
/*  89 */         Bukkit.broadcastMessage("§cLe serveur redémarre, vous êtes seul en jeu !");
/*  90 */         Bukkit.spigot().restart();
/*     */       }
/*     */     }
/*  93 */     else if (isState(States.LOBBY)) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void snowballListener()
/*     */   {
/* 101 */     Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
/*     */     {
/*     */       public void run()
/*     */       {
/* 105 */         for (Entity snowball : Bukkit.getWorld("world").getEntities()) {
/* 106 */           if ((snowball instanceof Snowball))
/*     */           {
/* 108 */             World world = snowball.getWorld();
/* 109 */             Location loc = snowball.getLocation().subtract(0.0D, 1.0D, 0.0D);
/* 110 */             Firework firework = (Firework)world.spawn(loc, Firework.class);
/* 111 */             FireworkMeta fm = firework.getFireworkMeta();
/* 112 */             FireworkEffect effect = FireworkEffect.builder()
/* 113 */               .flicker(false)
/* 114 */               .trail(false)
/* 115 */               .with(org.bukkit.FireworkEffect.Type.CREEPER)
/* 116 */               .withColor(Color.WHITE)
/* 117 */               .withColor(Color.GRAY)
/* 118 */               .withColor(Color.WHITE)
/* 119 */               .build();
/* 120 */             fm.clearEffects();
/* 121 */             fm.addEffect(effect);
/*     */             try
/*     */             {
/* 124 */               Field field = fm.getClass().getDeclaredField("power");
/* 125 */               field.setAccessible(true);
/* 126 */               field.set(fm, Integer.valueOf(-1));
/*     */             }
/*     */             catch (NoSuchFieldException e1)
/*     */             {
/* 130 */               e1.printStackTrace();
/*     */             }
/*     */             catch (SecurityException e1)
/*     */             {
/* 134 */               e1.printStackTrace();
/*     */             }
/*     */             catch (IllegalArgumentException e1)
/*     */             {
/* 138 */               e1.printStackTrace();
/*     */             }
/*     */             catch (IllegalAccessException e1)
/*     */             {
/* 142 */               e1.printStackTrace();
/*     */             }
/* 144 */             firework.setFireworkMeta(fm);
/*     */           }
/*     */         }
/*     */       }
/* 148 */     }, 0L, 1L);
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\ubc\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */