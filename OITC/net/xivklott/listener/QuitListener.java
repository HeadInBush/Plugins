/*    */ package net.xivklott.listener;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.xivklott.ubc.Main;
/*    */ import net.xivklott.ubc.States;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ 
/*    */ public class QuitListener implements Listener
/*    */ {
/* 12 */   String prefix = "§7[§cJeux d'Armes§7] §c";
/*    */   
/*    */   private Main main;
/*    */   
/*    */   public QuitListener(Main main)
/*    */   {
/* 18 */     this.main = main;
/*    */   }
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void onQuit(PlayerQuitEvent e)
/*    */   {
/* 24 */     Player player = e.getPlayer();
/* 25 */     if (this.main.isState(States.PLAYING)) {
/* 26 */       if (this.main.getPlayers().contains(player)) {
/* 27 */         this.main.getPlayers().remove(player);
/*    */       }
/* 29 */       e.setQuitMessage(this.prefix + player.getName() + " §aEst parti. §e[§6" + this.main.getPlayers().size() + "/6§e]");
/* 30 */       this.main.checkAlone();
/*    */     }
/* 32 */     else if (this.main.isState(States.LOBBY)) {
/* 33 */       e.setQuitMessage(this.prefix + player.getName() + " §aEst parti. §e[§6" + this.main.getPlayers().size() + "/6§e]");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\listener\QuitListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */