/*    */ package mq.xivklott.utils;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import mq.xivklott.commande.CmdBvn;
/*    */ import mq.xivklott.commande.CmdSmilePrison;
/*    */ import mq.xivklott.luckyblocks.Luckyblock;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class Main extends org.bukkit.plugin.java.JavaPlugin implements Listener
/*    */ {
/* 17 */   public String prefix = coloration("&7[&eSmilePrison&7] &c");
/*    */   
/*    */   FileConfiguration config;
/*    */   java.io.File cfile;
/* 21 */   public Material luckyblock = Material.getMaterial(getConfig().getString("luckyblock").toUpperCase());
/*    */   
/*    */   public void onEnable()
/*    */   {
/* 25 */     PluginManager pm = getServer().getPluginManager();
/* 26 */     System.out.println("[SmilePrison] Plugin ON");
/*    */     
/* 28 */     getCommand("bvn").setExecutor(new CmdBvn(this));
/* 29 */     getCommand("smileprison").setExecutor(new CmdSmilePrison(this));
/* 30 */     pm.registerEvents(new Luckyblock(this), this);
/*    */     
/* 32 */     getConfig().options().copyDefaults(true);
/* 33 */     saveDefaultConfig();
/*    */   }
/*    */   
/*    */   public String coloration(String msg)
/*    */   {
/* 38 */     String coloredMsg = "";
/* 39 */     for (int i = 0; i < msg.length(); i++) {
/* 40 */       if (msg.charAt(i) == '&') {
/* 41 */         coloredMsg = coloredMsg + '§';
/*    */       } else
/* 43 */         coloredMsg = coloredMsg + msg.charAt(i);
/*    */     }
/* 45 */     return coloredMsg;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\utilitaire.jar!\mq\xivklott\utils\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */