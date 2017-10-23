/*    */ package mq.xivklott.listener;
/*    */ 
/*    */ import mq.xivklott.Main;
/*    */ import mq.xivklott.States;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.EntityDeathEvent;
/*    */ 
/*    */ 
/*    */ public class AnnexListener
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public AnnexListener(Main main)
/*    */   {
/* 26 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onDG(EntityDamageEvent e)
/*    */   {
/* 32 */     if (!this.main.isState(States.PLAYING)) {
/* 33 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onDE(EntityDamageByEntityEvent e) {
/* 39 */     if (!this.main.isState(States.PLAYING)) {
/* 40 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntityDeath(EntityDeathEvent event) {
/* 46 */     event.setDroppedExp(0);
/*    */   }
/*    */   
/*    */   @EventHandler
/* 50 */   public void onBlockPlace(BlockPlaceEvent e) { e.setCancelled(true); }
/*    */   
/*    */   @EventHandler
/*    */   public void onBlockBreak(BlockBreakEvent e)
/*    */   {
/* 55 */     if ((!this.main.isState(States.MINING)) && (e.getBlock().getType() != Material.QUARTZ_ORE))
/*    */     {
/* 57 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void onDamage(EntityDamageEvent e)
/*    */   {
/* 67 */     if (!this.main.isState(States.PLAYING))
/*    */     {
/* 69 */       e.setCancelled(true);
/* 70 */       return;
/*    */     }
/*    */     
/* 73 */     Entity victim = e.getEntity();
/* 74 */     if ((victim instanceof Player))
/*    */     {
/*    */ 
/* 77 */       Player player = (Player)victim;
/* 78 */       if (player.getHealth() <= e.getDamage())
/*    */       {
/* 80 */         e.setDamage(0.0D);
/* 81 */         this.main.eliminate(player);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onFallingDamage(EntityDamageEvent event) {
/* 88 */     if (((event.getEntity() instanceof Player)) && 
/* 89 */       (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
/* 90 */       event.setCancelled(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\listener\AnnexListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */