/*    */ package net.xivklott.gun;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.Snowball;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class Gun implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInteractEvent(PlayerInteractEvent e)
/*    */   {
/* 22 */     ItemStack cut = new ItemStack(Material.BLAZE_ROD, 1);
/* 23 */     ItemMeta metapick = cut.getItemMeta();
/* 24 */     metapick.setDisplayName("§d§k!§5§k!§d§k! §fLanceur §d§k!§5§k!§d§k!");
/* 25 */     cut.setItemMeta(metapick);
/*    */     
/* 27 */     ItemStack revolverSeeds = new ItemStack(Material.SNOW_BALL, 8);
/* 28 */     ItemMeta metapick3 = revolverSeeds.getItemMeta();
/* 29 */     metapick3.setDisplayName("§eMunitions");
/* 30 */     revolverSeeds.setItemMeta(metapick3);
/*    */     
/* 32 */     ItemStack removeMunitions = new ItemStack(Material.SNOW_BALL, 1);
/* 33 */     ItemMeta removemetapick3 = removeMunitions.getItemMeta();
/* 34 */     removemetapick3.setDisplayName("§eMunitions");
/* 35 */     removeMunitions.setItemMeta(removemetapick3);
/*    */     
/* 37 */     Player p = e.getPlayer();
/* 38 */     if ((e.getAction() == Action.RIGHT_CLICK_AIR) && 
/* 39 */       (p.getItemInHand().getType() == Material.BLAZE_ROD)) {
/* 40 */       HashMap<Integer, ItemStack> resultrevolver = e.getPlayer().getInventory().removeItem(new ItemStack[] { removeMunitions });
/* 41 */       if (!resultrevolver.isEmpty()) {
/* 42 */         p.sendMessage("§eVous n'avez plus de munitions, §cbattez-vous au bâton!");
/*    */       } else {
/* 44 */         p.launchProjectile(Snowball.class);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void onDamageEvent(EntityDamageByEntityEvent e)
/*    */   {
/* 53 */     if ((e.getDamager() instanceof Snowball)) {
/* 54 */       Snowball s = (Snowball)e.getDamager();
/* 55 */       Player shooter = (Player)s.getShooter();
/* 56 */       if ((s.getShooter() instanceof Player))
/*    */       {
/* 58 */         if (shooter.getItemInHand().getType() == Material.BLAZE_ROD)
/*    */         {
/* 60 */           e.setDamage(8000.0D);
/* 61 */           shooter.getWorld().playEffect(e.getEntity().getLocation(), org.bukkit.Effect.STEP_SOUND, Material.GLOWSTONE);
/* 62 */           shooter.getInventory().remove(new ItemStack(Material.SNOW_BALL, 1));
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\gun\Gun.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */