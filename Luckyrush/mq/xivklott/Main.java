/*     */ package mq.xivklott;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataOutput;
/*     */ import com.google.common.io.ByteStreams;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mq.xivklott.listener.JoinListener;
/*     */ import mq.xivklott.listener.QuitListener;
/*     */ import mq.xivklott.utils.Title;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Server.Spigot;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.plugin.messaging.Messenger;
/*     */ 
/*     */ public class Main extends JavaPlugin implements Listener
/*     */ {
/*     */   private States state;
/*  26 */   private List<Location> spawns = new ArrayList();
/*  27 */   private List<Location> pspawns = new ArrayList();
/*  28 */   public List<Player> players = new ArrayList();
/*     */   private SqlConnection sql;
/*  30 */   ByteArrayDataOutput out = ByteStreams.newDataOutput();
/*     */   
/*     */   public Main(SqlConnection sql) {
/*  33 */     this.sql = sql;
/*     */   }
/*     */   
/*     */   public void onEnable() {
/*  37 */     getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
/*  38 */     this.sql = new SqlConnection("jdbc:mysql://", "localhost <- Adresse PhpMyAdmin", "BaseDeDonée", "Identifiant", "MotDePasse");
/*  39 */     this.sql.connection();
/*     */     
/*  41 */     setState(States.LOBBY);
/*  42 */     System.out.println("plugin on");
/*  43 */     World world = Bukkit.getWorld("world");
/*  44 */     PluginManager pm = Bukkit.getServer().getPluginManager();
/*  45 */     pm.registerEvents(new JoinListener(this), this);
/*  46 */     pm.registerEvents(new QuitListener(this), this);
/*     */     
/*     */ 
/*  49 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  50 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  51 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  52 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  53 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  54 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  55 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  56 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  57 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  58 */     this.spawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*     */     
/*     */ 
/*  61 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  62 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  63 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  64 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  65 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  66 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  67 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  68 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  69 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*  70 */     this.pspawns.add(new Location(world, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F));
/*     */     
/*  72 */     getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
/*  73 */     super.onEnable();
/*     */   }
/*     */   
/*     */   public void onDisable() {
/*  77 */     System.out.println("plugin off");
/*  78 */     this.sql.disconnect();
/*  79 */     getServer().dispatchCommand(getServer().getConsoleSender(), "save-off");
/*  80 */     super.onDisable();
/*     */   }
/*     */   
/*     */   public void setState(States state) {
/*  84 */     this.state = state;
/*     */   }
/*     */   
/*     */   public boolean isState(States state) {
/*  88 */     return this.state == state;
/*     */   }
/*     */   
/*     */   public List<Player> getPlayers() {
/*  92 */     return this.players;
/*     */   }
/*     */   
/*     */   public List<Location> getSpawns() {
/*  96 */     return this.spawns;
/*     */   }
/*     */   
/*     */   public List<Location> getPlayingSpawns() {
/* 100 */     return this.pspawns;
/*     */   }
/*     */   
/*     */   public void checkWin() {
/* 104 */     if (this.players.size() == 0)
/*     */     {
/* 106 */       setState(States.FINISH);
/* 107 */       Bukkit.spigot().restart();
/*     */     }
/*     */     
/* 110 */     if (this.players.size() == 1) {
/* 111 */       setState(States.FINISH);
/*     */       
/* 113 */       Player winner = (Player)this.players.get(0);
/* 114 */       Bukkit.broadcastMessage("§b§lGrand gagnant §7: §1§k!§b§k!§1§k!§f§l§f§l " + ((Player)this.players.get(0)).getPlayer().getName() + "§1§k !§b§k!§1§k!");
/*     */       
/* 116 */       Bukkit.broadcastMessage("§aRemise des prix ! Téléportation au Hub dans quelques secondes..");
/*     */       
/*     */ 
/* 119 */       for (Player pl : Bukkit.getOnlinePlayers()) {
/* 120 */         this.sql.addMoney(pl, 25);
/* 121 */         pl.sendMessage("§eTu as gagné 25 coins en terminant cette partie !");
/*     */         
/* 123 */         this.sql.addMoney(winner, 25);
/* 124 */         winner.sendMessage("§eTu as gagné 50 coins en remportant cette partie ! Bien joué !");
/*     */         
/* 126 */         Bukkit.broadcastMessage("§7Téléportation au lobby en cours...");
/* 127 */         this.out.writeUTF("Connect");
/* 128 */         this.out.writeUTF("Hub");
/* 129 */         pl.sendPluginMessage(this, "BungeeCord", this.out.toByteArray());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void eliminate(Player player)
/*     */   {
/* 136 */     if (this.players.contains(player)) this.players.remove(player);
/* 137 */     player.setGameMode(GameMode.SPECTATOR);
/* 138 */     Title.sendTitle(player, "§c☠ §c§lVous êtes Mort §c☠", "§bC'est fini pour toi !", 20);
/* 139 */     Title.sendActionBar(player, "§b§lVous êtes éliminé !");
/* 140 */     checkWin();
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */