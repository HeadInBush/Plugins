/*    */ package mq.xivklott.listener;
/*    */ 
/*    */ import java.util.List;
/*    */ import mq.xivklott.Main;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ 
/*    */ public class QuitListener
/*    */   implements Listener
/*    */ {
/* 14 */   String prefix = "§7[§cJeux d'Armes§7] §c";
/*    */   private Main main;
/*    */   
/*    */   public QuitListener(Main main) {
/* 18 */     this.main = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void onQuit(PlayerQuitEvent e)
/*    */   {
/* 26 */     Player player = e.getPlayer();
/* 27 */     if (this.main.getPlayers().contains(player)) {
/* 28 */       this.main.getPlayers().remove(player);
/*    */     }
/* 30 */     e.setQuitMessage(this.prefix + player.getName() + " §aEst parti. §e[§6" + this.main.getPlayers().size() + "/10§e]");
/* 31 */     this.main.checkWin();
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\listener\QuitListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */