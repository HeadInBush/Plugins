/*    */ package net.xivklott.listener;
/*    */ 
/*    */ import net.xivklott.ubc.Main;
/*    */ import net.xivklott.ubc.SqlConnection;
/*    */ import net.xivklott.ubc.States;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerLevelChangeEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class PlayerListener implements Listener
/*    */ {
/*    */   private Main main;
/*    */   SqlConnection sql;
/*    */   
/*    */   public PlayerListener(SqlConnection sql)
/*    */   {
/* 23 */     this.sql = sql;
/*    */   }
/*    */   
/*    */   public ItemStack Munitions() {
/* 27 */     ItemStack is = new ItemStack(Material.SNOW_BALL, 1);
/* 28 */     ItemMeta im = is.getItemMeta();
/* 29 */     im.setDisplayName("§eMunitions");
/* 30 */     is.setItemMeta(im);
/* 31 */     return is;
/*    */   }
/*    */   
/*    */   public PlayerListener(Main main)
/*    */   {
/* 36 */     this.main = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void EDBEE(EntityDamageByEntityEvent e)
/*    */   {
/* 44 */     if ((e.getDamager() instanceof Player)) {
/* 45 */       Player p = (Player)e.getDamager();
/* 46 */       ItemStack click = p.getItemInHand();
/* 47 */       if ((click.getType() == Material.STICK) && (click.getItemMeta().getDisplayName().equalsIgnoreCase("§cBâton puissant")))
/*    */       {
/* 49 */         e.setDamage(8000.0D);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void checkWin(PlayerLevelChangeEvent e) {
/* 56 */     Player p = e.getPlayer();
/*    */     
/* 58 */     if ((this.main.isState(States.PLAYING)) && (p.getLevel() == 20)) {
/* 59 */       this.main.setState(States.FINISH);
/* 60 */       for (Player player : Bukkit.getOnlinePlayers()) {
/* 61 */         net.xivklott.ubc.Title.sendTitle(player, "§bFin de la partie !", "§e§lVainqueur : §a" + p.getName() + " §e§l!", 40);
/*    */         
/*    */ 
/* 64 */         this.sql.addMoney(player, 25);
/* 65 */         player.sendMessage("§eTu as gagné 25 coins en terminant cette partie !");
/*    */         
/* 67 */         this.sql.addMoney(p, 25);
/* 68 */         p.sendMessage("§eTu as gagné 50 coins en remportant cette partie ! Bien joué !");
/*    */         
/* 70 */         Bukkit.broadcastMessage("§7Téléportation au lobby en cours...");
/* 71 */         this.main.Lobbytp(player);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\listener\PlayerListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */