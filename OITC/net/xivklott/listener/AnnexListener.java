/*    */ package net.xivklott.listener;
/*    */ 
/*    */ import net.xivklott.ubc.Main;
/*    */ import net.xivklott.ubc.States;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.ExperienceOrb;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.EntityDeathEvent;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*    */ import org.bukkit.event.entity.ItemSpawnEvent;
/*    */ import org.bukkit.event.player.PlayerDropItemEvent;
/*    */ 
/*    */ public class AnnexListener implements Listener
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public AnnexListener(Main main)
/*    */   {
/* 24 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onFL(FoodLevelChangeEvent e) {
/* 29 */     e.setCancelled(true);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onDG(EntityDamageEvent e) {
/* 34 */     if (this.main.isState(States.LOBBY)) {
/* 35 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void onDE(EntityDamageByEntityEvent e)
/*    */   {
/* 43 */     if (this.main.isState(States.LOBBY)) {
/* 44 */       e.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntityDeath(EntityDeathEvent event) {
/* 50 */     event.setDroppedExp(0);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onEntitySpawn(ItemSpawnEvent event) {
/* 55 */     Entity entity = event.getEntity();
/* 56 */     if ((entity instanceof ExperienceOrb)) {
/* 57 */       event.setCancelled(true);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onDrop(PlayerDropItemEvent e) {
/* 63 */     e.setCancelled(true);
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onFallingDamage(EntityDamageEvent event) {
/* 68 */     if (((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
/* 69 */       event.setCancelled(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\listener\AnnexListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */