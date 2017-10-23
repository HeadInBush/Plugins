/*     */ package mq.xivklott.commande;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import me.clip.deluxetags.DeluxeTag;
/*     */ import me.clip.ezprestige.PrestigeManager;
/*     */ import mq.xivklott.utils.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class CmdBvn implements CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   
/*     */   public CmdBvn(Main main)
/*     */   {
/*  22 */     this.main = main;
/*     */   }
/*     */   
/*  25 */   private Map<String, Long> cooldowns = new HashMap();
/*     */   
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
/*     */   {
/*  30 */     if ((sender instanceof Player))
/*     */     {
/*  32 */       Player p = (Player)sender;
/*  33 */       if (cmd.getName().equalsIgnoreCase("bvn"))
/*     */       {
/*  35 */         if ((!p.getPlayer().isOp()) || (!p.hasPermission("staff.bvn"))) {
/*  36 */           if (this.cooldowns.containsKey(p.getName()))
/*     */           {
/*  38 */             int seconds = 5;
/*  39 */             long timeleft = ((Long)this.cooldowns.get(p.getName())).longValue() / 1000L + seconds - 
/*  40 */               System.currentTimeMillis() / 1000L;
/*  41 */             if (timeleft > 0L) {
/*  42 */               p.sendMessage(this.main.prefix + "Il te reste " + timeleft + "s avant d'utiliser /bvn !");
/*     */               
/*  44 */               return false;
/*     */             }
/*     */           }
/*     */           
/*  48 */           int r = new Random().nextInt(5);
/*     */           
/*  50 */           switch (r) {
/*     */           case 0: 
/*  52 */             Bukkit.broadcastMessage(this.main.coloration(PrestigeManager.getCurrentPrestigeTag(p) + " " + 
/*  53 */               this.main.coloration(new StringBuilder(String.valueOf(DeluxeTag.getPlayerDisplayTag(p))).append(" ").append(p.getDisplayName())
/*  54 */               .append(this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("normal-player-1")).toString())).toString())));
/*     */             
/*  56 */             break;
/*     */           case 1: 
/*  58 */             Bukkit.broadcastMessage(this.main.coloration(PrestigeManager.getCurrentPrestigeTag(p) + " " + 
/*  59 */               this.main.coloration(new StringBuilder(String.valueOf(DeluxeTag.getPlayerDisplayTag(p))).append(" ").append(p.getDisplayName())
/*  60 */               .append(this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("normal-player-2")).toString())).toString())));
/*  61 */             break;
/*     */           case 2: 
/*  63 */             Bukkit.broadcastMessage(this.main.coloration(PrestigeManager.getCurrentPrestigeTag(p) + " " + 
/*  64 */               this.main.coloration(new StringBuilder(String.valueOf(DeluxeTag.getPlayerDisplayTag(p))).append(" ").append(p.getDisplayName())
/*  65 */               .append(this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("normal-player-3")).toString())).toString())));
/*  66 */             break;
/*     */           case 3: 
/*  68 */             Bukkit.broadcastMessage(this.main.coloration(PrestigeManager.getCurrentPrestigeTag(p) + " " + 
/*  69 */               this.main.coloration(new StringBuilder(String.valueOf(DeluxeTag.getPlayerDisplayTag(p))).append(" ").append(p.getDisplayName())
/*  70 */               .append(this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("normal-player-4")).toString())).toString())));
/*  71 */             break;
/*     */           case 4: 
/*  73 */             Bukkit.broadcastMessage(this.main.coloration(PrestigeManager.getCurrentPrestigeTag(p) + " " + 
/*  74 */               this.main.coloration(new StringBuilder(String.valueOf(DeluxeTag.getPlayerDisplayTag(p))).append(" ").append(p.getDisplayName())
/*  75 */               .append(this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("normal-player-5")).toString())).toString())));
/*     */           }
/*     */           
/*     */           
/*     */ 
/*  80 */           this.cooldowns.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
/*     */ 
/*     */ 
/*     */         }
/*  84 */         else if ((p.isOp()) || (p.hasPermission("staff.bvn"))) {
/*  85 */           if (this.cooldowns.containsKey(p.getName()))
/*     */           {
/*  87 */             int seconds = 5;
/*  88 */             long timeleft = ((Long)this.cooldowns.get(p.getName())).longValue() / 1000L + seconds - 
/*  89 */               System.currentTimeMillis() / 1000L;
/*  90 */             if (timeleft > 0L) {
/*  91 */               p.sendMessage(this.main.prefix + "Il te reste " + timeleft + "s avant d'utiliser /bvn !");
/*     */               
/*  93 */               return false;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*  98 */           int r = new Random().nextInt(5);
/*     */           
/* 100 */           switch (r) {
/*     */           case 0: 
/* 102 */             Bukkit.broadcastMessage(this.main.coloration(
/* 103 */               "&7[&cSTAFF&7] " + DeluxeTag.getPlayerDisplayTag(p) + " " + p.getDisplayName() + 
/* 104 */               this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("staff-player-1")).toString())));
/*     */             
/* 106 */             break;
/*     */           case 1: 
/* 108 */             Bukkit.broadcastMessage(this.main.coloration(
/* 109 */               "&7[&cSTAFF&7] " + DeluxeTag.getPlayerDisplayTag(p) + " " + p.getDisplayName() + 
/* 110 */               this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("staff-player-2")).toString())));
/* 111 */             break;
/*     */           case 2: 
/* 113 */             Bukkit.broadcastMessage(this.main.coloration(
/* 114 */               "&7[&cSTAFF&7] " + DeluxeTag.getPlayerDisplayTag(p) + " " + p.getDisplayName() + 
/* 115 */               this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("staff-player-3")).toString())));
/* 116 */             break;
/*     */           case 3: 
/* 118 */             Bukkit.broadcastMessage(this.main.coloration(
/* 119 */               "&7[&cSTAFF&7] " + DeluxeTag.getPlayerDisplayTag(p) + " " + p.getDisplayName() + 
/* 120 */               this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("staff-player-4")).toString())));
/* 121 */             break;
/*     */           case 4: 
/* 123 */             Bukkit.broadcastMessage(this.main
/* 124 */               .coloration("&7[&cSTAFF&7] " + DeluxeTag.getPlayerDisplayTag(p) + p.getDisplayName() + 
/* 125 */               this.main.coloration(new StringBuilder(" &6» ").append(this.main.getConfig().getString("staff-player-5")).toString())));
/*     */           }
/*     */           
/*     */           
/* 129 */           this.cooldowns.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */       return false;
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\utilitaire.jar!\mq\xivklott\commande\CmdBvn.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */