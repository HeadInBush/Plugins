/*    */ package mq.xivklott.commande;
/*    */ 
/*    */ import mq.xivklott.utils.Main;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CmdSmilePrison
/*    */   implements CommandExecutor
/*    */ {
/*    */   public CmdSmilePrison(Main main) {}
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
/*    */   {
/* 19 */     if ((sender instanceof Player)) {
/* 20 */       Player p = (Player)sender;
/* 21 */       if (cmd.getName().equalsIgnoreCase("smileprison")) {
/* 22 */         p.sendMessage("§a§m------§e§m---§a§m------§r §6§lSmile§e§lPrison §a§m------§e§m---§a§m------");
/* 23 */         p.sendMessage("§b§oPlugin créer par §cHidesekken");
/* 24 */         p.sendMessage(" ");
/* 25 */         p.sendMessage("§bCe plugin contient les luckyblocks du serveur,");
/* 26 */         p.sendMessage("§bAinsi que le §e/bvn");
/* 27 */         p.sendMessage(" ");
/* 28 */         p.sendMessage("§a§m------§e§m---§a§m------§r §6§lSmile§e§lPrison §a§m------§e§m---§a§m------");
/*    */       }
/*    */     }
/*    */     
/* 32 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\utilitaire.jar!\mq\xivklott\commande\CmdSmilePrison.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */