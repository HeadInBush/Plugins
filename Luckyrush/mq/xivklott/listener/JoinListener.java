/*     */ package mq.xivklott.listener;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mq.xivklott.Main;
/*     */ import mq.xivklott.States;
/*     */ import mq.xivklott.utils.Title;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class JoinListener implements org.bukkit.event.Listener
/*     */ {
/*  17 */   String prefix = "§c[§eLuckyRush§c] §e";
/*     */   
/*     */   private Main main;
/*  20 */   int timer = 180;
/*     */   
/*     */   int task;
/*     */   
/*     */   public JoinListener(Main main)
/*     */   {
/*  26 */     this.main = main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @org.bukkit.event.EventHandler
/*     */   public void onJoin(PlayerJoinEvent e)
/*     */   {
/*  34 */     Player player = e.getPlayer();
/*  35 */     Location lobby = new Location(Bukkit.getWorld("world"), 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
/*  36 */     player.teleport(lobby);
/*  37 */     player.getInventory().clear();
/*  38 */     player.setFoodLevel(20);
/*  39 */     player.setMaxHealth(40.0D);
/*  40 */     player.setHealth(40.0D);
/*     */     
/*  42 */     if (!this.main.isState(States.LOBBY)) {
/*  43 */       player.setGameMode(GameMode.SPECTATOR);
/*  44 */       player.sendMessage("§7Une partie est en cours !");
/*  45 */       e.setJoinMessage(null);
/*  46 */       return;
/*     */     }
/*     */     
/*  49 */     if (!this.main.getPlayers().contains(player)) {
/*  50 */       this.main.getPlayers().add(player);
/*     */     }
/*  52 */     player.setGameMode(GameMode.ADVENTURE);
/*  53 */     e.setJoinMessage(this.prefix + player.getName() + " §aRejoint le lobby. §e[§6" + this.main.getPlayers().size() + "/10§e]");
/*  54 */     if ((this.main.isState(States.LOBBY)) && (this.main.getPlayers().size() == 2))
/*     */     {
/*  56 */       this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable()
/*     */       {
/*     */ 
/*     */         public void run()
/*     */         {
/*     */ 
/*  62 */           JoinListener.this.timer -= 1;
/*     */           
/*     */ 
/*  65 */           for (Player pl : Bukkit.getOnlinePlayers()) {
/*  66 */             if (JoinListener.this.timer == 190) {
/*  67 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a10s §b!", 20);
/*  68 */             } else if (JoinListener.this.timer == 185) {
/*  69 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a5s §b!", 20);
/*  70 */             } else if (JoinListener.this.timer == 184) {
/*  71 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a4s §b!", 20);
/*  72 */             } else if (JoinListener.this.timer == 183) {
/*  73 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a3s §b!", 20);
/*  74 */             } else if (JoinListener.this.timer == 182) {
/*  75 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a2s §b!", 20);
/*  76 */             } else if (JoinListener.this.timer == 181) {
/*  77 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie dans", "§a1s §b!", 20);
/*     */             }
/*     */           }
/*     */           Object player;
/*  81 */           if (JoinListener.this.timer == 180) {
/*  82 */             for (int i = 0; i < JoinListener.this.main.getPlayers().size(); i++)
/*     */             {
/*  84 */               player = (Player)JoinListener.this.main.getPlayers().get(i);
/*  85 */               Location spawn = (Location)JoinListener.this.main.getSpawns().get(i);
/*  86 */               JoinListener.this.main.setState(States.MINING);
/*  87 */               ((Player)player).teleport(spawn);
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*  92 */           if ((JoinListener.this.timer < 180) && (JoinListener.this.timer != 0)) {
/*  93 */             for (player = Bukkit.getOnlinePlayers().iterator(); ((Iterator)player).hasNext();) { Player pl = (Player)((Iterator)player).next();
/*  94 */               Title.sendActionBar(pl, "§c§lPVP dans §e§l" + JoinListener.this.timer + " §a§ls §b§l!");
/*     */             }
/*     */           }
/*     */           
/*  98 */           if (JoinListener.this.timer == 0) {
/*  99 */             for (int i = 0; i < JoinListener.this.main.getPlayers().size(); i++)
/*     */             {
/* 101 */               Player player = (Player)JoinListener.this.main.getPlayers().get(i);
/* 102 */               Location spawns = (Location)JoinListener.this.main.getPlayingSpawns().get(i);
/* 103 */               JoinListener.this.main.setState(States.PLAYING);
/* 104 */               player.teleport(spawns);
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/*     */         
/* 111 */       }, 20L, 20L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\listener\JoinListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */