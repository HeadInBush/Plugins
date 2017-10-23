/*     */ package net.xivklott.listener;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.xivklott.ubc.Main;
/*     */ import net.xivklott.ubc.Title;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class DeathListener implements org.bukkit.event.Listener
/*     */ {
/*  21 */   int timer = 6;
/*     */   
/*     */   int task;
/*     */   private Main main;
/*     */   
/*     */   public DeathListener(Main main)
/*     */   {
/*  28 */     this.main = main;
/*     */   }
/*     */   
/*     */   public ItemStack Munitions() {
/*  32 */     ItemStack is = new ItemStack(Material.SNOW_BALL, 1);
/*  33 */     ItemMeta im = is.getItemMeta();
/*  34 */     im.setDisplayName("§eMunitions");
/*  35 */     is.setItemMeta(im);
/*  36 */     return is;
/*     */   }
/*     */   
/*     */   public ItemStack Couteau()
/*     */   {
/*  41 */     ItemStack is1 = new ItemStack(Material.STICK, 1);
/*  42 */     ItemMeta im1 = is1.getItemMeta();
/*  43 */     im1.setDisplayName("§cBâton puissant");
/*  44 */     is1.setItemMeta(im1);
/*  45 */     return is1;
/*     */   }
/*     */   
/*     */   public ItemStack Lanceur() {
/*  49 */     ItemStack is2 = new ItemStack(Material.BLAZE_ROD, 1);
/*  50 */     ItemMeta metapick = is2.getItemMeta();
/*  51 */     metapick.setDisplayName("§d§k!§5§k!§d§k! §fLanceur §d§k!§5§k!§d§k!");
/*  52 */     is2.setItemMeta(metapick);
/*  53 */     return is2;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onDamage(EntityDamageByEntityEvent e)
/*     */   {
/*  59 */     if (!this.main.isState(net.xivklott.ubc.States.PLAYING))
/*     */     {
/*     */ 
/*  62 */       e.setCancelled(true);
/*  63 */       return;
/*     */     }
/*     */     
/*  66 */     Entity victim = e.getEntity();
/*  67 */     Entity damager = e.getDamager();
/*  68 */     if ((victim instanceof Player))
/*     */     {
/*     */ 
/*  71 */       final Player player = (Player)victim;
/*  72 */       if (player.getHealth() <= e.getDamage())
/*     */       {
/*  74 */         e.setDamage(0.0D);
/*  75 */         int leveldefeat = ((Player)victim).getLevel();
/*  76 */         if (leveldefeat > 0) {
/*  77 */           ((Player)victim).setLevel(leveldefeat - 1);
/*     */           
/*  79 */           int level = ((Player)damager).getLevel();
/*  80 */           ((Player)damager).setLevel(level + 1);
/*     */           
/*  82 */           for (Player pls : Bukkit.getOnlinePlayers())
/*     */           {
/*  84 */             Title.sendActionBar(pls, "§a" + victim + " §eà été tué par §c" + damager);
/*     */           }
/*     */         }
/*     */         
/*  88 */         player.setGameMode(GameMode.SPECTATOR);
/*  89 */         this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable()
/*     */         {
/*     */ 
/*     */           public void run()
/*     */           {
/*  94 */             DeathListener.this.timer -= 1;
/*     */             
/*     */ 
/*     */ 
/*  98 */             if ((DeathListener.this.timer == 5) || (DeathListener.this.timer == 4) || (DeathListener.this.timer == 3) || (DeathListener.this.timer == 2) || (DeathListener.this.timer == 1)) {
/*  99 */               Title.sendTitle(player, "§c☠ §c§lVous êtes Mort §c☠", "§bRéapparition dans §e" + DeathListener.this.timer + "s §b!", 20);
/*     */             }
/*     */             
/* 102 */             if (DeathListener.this.timer == 0) {
/* 103 */               player.setGameMode(GameMode.SURVIVAL);
/* 104 */               player.getInventory().setItem(4, DeathListener.this.Munitions());
/* 105 */               player.getInventory().setItem(1, DeathListener.this.Lanceur());
/* 106 */               player.getInventory().setItem(2, DeathListener.this.Couteau());
/* 107 */               double maxHealth = player.getMaxHealth();
/* 108 */               player.setHealth(maxHealth);
/* 109 */               for (int i = 0; i < DeathListener.this.main.getSpawns().size(); i++)
/*     */               {
/* 111 */                 Location spawn = (Location)DeathListener.this.main.getSpawns().get(i);
/* 112 */                 player.teleport(spawn);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/* 117 */         }, 20L, 20L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\listener\DeathListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */