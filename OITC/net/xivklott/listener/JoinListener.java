/*     */ package net.xivklott.listener;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.xivklott.ubc.Main;
/*     */ import net.xivklott.ubc.States;
/*     */ import net.xivklott.ubc.Title;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class JoinListener implements org.bukkit.event.Listener
/*     */ {
/*  23 */   String prefix = "§7[§cJeux d'Armes§7] §c";
/*     */   
/*     */   private Main main;
/*  26 */   int timer = 11;
/*     */   
/*     */   int task;
/*     */   
/*     */   public JoinListener(Main main)
/*     */   {
/*  32 */     this.main = main;
/*     */   }
/*     */   
/*     */   public ItemStack Munitions() {
/*  36 */     ItemStack is = new ItemStack(Material.SNOW_BALL, 1);
/*  37 */     ItemMeta im = is.getItemMeta();
/*  38 */     im.setDisplayName("§eMunitions");
/*  39 */     is.setItemMeta(im);
/*  40 */     return is;
/*     */   }
/*     */   
/*     */   public ItemStack Couteau()
/*     */   {
/*  45 */     ItemStack is1 = new ItemStack(Material.STICK, 1);
/*  46 */     ItemMeta im1 = is1.getItemMeta();
/*  47 */     im1.setDisplayName("§cBâton puissant");
/*  48 */     is1.setItemMeta(im1);
/*  49 */     return is1;
/*     */   }
/*     */   
/*     */   public ItemStack Lanceur() {
/*  53 */     ItemStack is2 = new ItemStack(Material.BLAZE_ROD, 1);
/*  54 */     ItemMeta metapick = is2.getItemMeta();
/*  55 */     metapick.setDisplayName("§d§k!§5§k!§d§k! §fLanceur §d§k!§5§k!§d§k!");
/*  56 */     is2.setItemMeta(metapick);
/*  57 */     return is2;
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e)
/*     */   {
/*  64 */     Player player = e.getPlayer();
/*  65 */     Location lobby = new Location(Bukkit.getWorld("world"), -240.735D, 80.0D, 70.51D, -174.4F, -12.9F);
/*     */     
/*  67 */     ItemStack wdoor = new ItemStack(Material.WOOD_DOOR, 1);
/*  68 */     ItemMeta wdoorM = wdoor.getItemMeta();
/*  69 */     wdoorM.addEnchant(Enchantment.DURABILITY, 1, true);
/*  70 */     wdoorM.setDisplayName("§cRetour au Hub §7| §eClique droit pour y aller");
/*  71 */     wdoorM.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
/*  72 */     wdoorM.hasItemFlag(ItemFlag.HIDE_UNBREAKABLE);
/*  73 */     wdoorM.hasItemFlag(ItemFlag.HIDE_PLACED_ON);
/*  74 */     wdoorM.hasItemFlag(ItemFlag.HIDE_DESTROYS);
/*  75 */     wdoor.setItemMeta(wdoorM);
/*     */     
/*  77 */     player.teleport(lobby);
/*  78 */     player.setFoodLevel(20);
/*  79 */     player.setMaxHealth(40.0D);
/*  80 */     player.setHealth(40.0D);
/*  81 */     player.getInventory().clear();
/*  82 */     player.getInventory().setHelmet(null);
/*  83 */     player.getInventory().setChestplate(null);
/*  84 */     player.getInventory().setLeggings(null);
/*  85 */     player.getInventory().setBoots(null);
/*  86 */     player.getInventory().setItem(8, wdoor);
/*  87 */     player.setLevel(0);
/*  88 */     player.setExp(0.0F);
/*     */     
/*  90 */     if (!this.main.isState(States.LOBBY)) {
/*  91 */       player.setGameMode(GameMode.SPECTATOR);
/*  92 */       Title.sendTitle(player, "§7Une partie est en cours !", "§e/hub pour retourner au Hub !", 20);
/*  93 */       player.getInventory().setItem(8, wdoor);
/*  94 */       e.setJoinMessage(null);
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     if (!this.main.getPlayers().contains(player))
/*  99 */       this.main.getPlayers().add(player);
/* 100 */     player.setGameMode(GameMode.ADVENTURE);
/* 101 */     for (Player pls : Bukkit.getOnlinePlayers()) {
/* 102 */       Title.sendActionBar(pls, this.prefix + player.getName() + " §aa rejoint le lobby. §e[§6" + this.main.getPlayers().size() + "/6§e]");
/*     */     }
/*     */     
/*     */ 
/* 106 */     if ((this.main.isState(States.LOBBY)) && (this.main.getPlayers().size() == 4))
/*     */     {
/* 108 */       this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.main, new Runnable()
/*     */       {
/*     */ 
/*     */         public void run()
/*     */         {
/* 113 */           JoinListener.this.timer -= 1;
/*     */           
/*     */ 
/*     */ 
/* 117 */           if ((JoinListener.this.timer == 10) || (JoinListener.this.timer == 5) || (JoinListener.this.timer == 4) || (JoinListener.this.timer == 3) || (JoinListener.this.timer == 2) || (JoinListener.this.timer == 1)) {
/* 118 */             for (Player pl : Bukkit.getOnlinePlayers()) {
/* 119 */               Title.sendActionBar(pl, JoinListener.this.prefix + "§bLancement de la partie dans §a" + JoinListener.this.timer + "s §b!");
/* 120 */               Title.sendTitle(pl, JoinListener.this.prefix + "§bLancement de la partie", " dans §a" + JoinListener.this.timer + "s §b!", 20);
/*     */             }
/*     */           }
/*     */           
/* 124 */           if (JoinListener.this.timer == 0) {
/* 125 */             for (int i = 0; i < JoinListener.this.main.getPlayers().size(); i++)
/*     */             {
/* 127 */               Player player = (Player)JoinListener.this.main.getPlayers().get(i);
/* 128 */               Location spawn = (Location)JoinListener.this.main.getSpawns().get(i);
/* 129 */               JoinListener.this.main.setState(States.PLAYING);
/* 130 */               player.getInventory().setItem(4, JoinListener.this.Munitions());
/* 131 */               player.getInventory().setItem(1, JoinListener.this.Lanceur());
/* 132 */               player.getInventory().setItem(2, JoinListener.this.Couteau());
/* 133 */               player.teleport(spawn);
/* 134 */               Title.sendActionBar(player, JoinListener.this.prefix + "§e Bonne chance !");
/* 135 */               Title.sendTitle(player, JoinListener.this.prefix + "§eBonne chance !", " §d:)", 20);
/*     */             }
/*     */             
/*     */           }
/*     */         }
/* 140 */       }, 20L, 20L);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\listener\JoinListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */