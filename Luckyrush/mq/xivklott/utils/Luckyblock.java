/*     */ package mq.xivklott.utils;
/*     */ 
/*     */ import java.util.Random;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ public class Luckyblock
/*     */   implements Listener
/*     */ {
/*     */   public ItemStack item1()
/*     */   {
/*  24 */     ItemStack is1 = new ItemStack(Material.DIAMOND_SWORD, 1);
/*  25 */     ItemMeta metapick1 = is1.getItemMeta();
/*  26 */     metapick1.addEnchant(Enchantment.DURABILITY, 1, true);
/*  27 */     metapick1.addEnchant(Enchantment.KNOCKBACK, 2, true);
/*  28 */     metapick1.setDisplayName("§bUne épée féroce ! >:(");
/*  29 */     metapick1.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  30 */     metapick1.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*     */     
/*  32 */     is1.setItemMeta(metapick1);
/*  33 */     return is1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item2()
/*     */   {
/*  40 */     ItemStack is2 = new ItemStack(Material.WOOD_SWORD, 1);
/*  41 */     ItemMeta metapick2 = is2.getItemMeta();
/*  42 */     metapick2.addEnchant(Enchantment.THORNS, 2, true);
/*  43 */     metapick2.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
/*  44 */     metapick2.setDisplayName("§cLa Glaive de l'imagination..");
/*  45 */     metapick2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  46 */     metapick2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  47 */     is2.setItemMeta(metapick2);
/*  48 */     return is2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack item3()
/*     */   {
/*  56 */     ItemStack is3 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
/*  57 */     ItemMeta metapick3 = is3.getItemMeta();
/*  58 */     metapick3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
/*  59 */     metapick3.setDisplayName("§7Un casque très utile ! ");
/*  60 */     metapick3.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  61 */     metapick3.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  62 */     is3.setItemMeta(metapick3);
/*  63 */     return is3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item4()
/*     */   {
/*  70 */     ItemStack is4 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
/*  71 */     ItemMeta metapick4 = is4.getItemMeta();
/*  72 */     metapick4.addEnchant(Enchantment.PROTECTION_PROJECTILE, 4, true);
/*  73 */     metapick4.setDisplayName("§cLe plastron de l'imagination...");
/*  74 */     metapick4.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  75 */     metapick4.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  76 */     is4.setItemMeta(metapick4);
/*  77 */     return is4;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item5()
/*     */   {
/*  84 */     ItemStack is5 = new ItemStack(Material.BOW, 1);
/*  85 */     ItemMeta metapick5 = is5.getItemMeta();
/*  86 */     metapick5.addEnchant(Enchantment.DURABILITY, 300, true);
/*  87 */     metapick5.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
/*  88 */     metapick5.setDisplayName("§5Arc très méchant |:(");
/*  89 */     metapick5.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  90 */     metapick5.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/*  91 */     is5.setItemMeta(metapick5);
/*  92 */     return is5;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item6()
/*     */   {
/*  99 */     ItemStack is6 = new ItemStack(Material.GOLDEN_APPLE, 1);
/* 100 */     ItemMeta metapick6 = is6.getItemMeta();
/* 101 */     metapick6.setDisplayName("§eUne jolie pomme dorée");
/* 102 */     metapick6.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 103 */     metapick6.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 104 */     is6.setItemMeta(metapick6);
/* 105 */     return is6;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item7()
/*     */   {
/* 112 */     ItemStack is7 = new ItemStack(Material.FISHING_ROD, 1);
/* 113 */     ItemMeta metapick7 = is7.getItemMeta();
/* 114 */     metapick7.addEnchant(Enchantment.DURABILITY, 300, true);
/* 115 */     metapick7.addEnchant(Enchantment.KNOCKBACK, 2, true);
/* 116 */     metapick7.setDisplayName("§dUne sacrée canne à  pèche :o");
/* 117 */     metapick7.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 118 */     metapick7.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 119 */     is7.setItemMeta(metapick7);
/* 120 */     return is7;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item8()
/*     */   {
/* 127 */     ItemStack is8 = new ItemStack(Material.BAKED_POTATO, 1);
/* 128 */     ItemMeta metapick8 = is8.getItemMeta();
/* 129 */     metapick8.setDisplayName("&6Une patate cuite :v");
/* 130 */     metapick8.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 131 */     metapick8.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 132 */     is8.setItemMeta(metapick8);
/* 133 */     return is8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item9()
/*     */   {
/* 140 */     ItemStack is9 = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
/* 141 */     ItemMeta metapick9 = is9.getItemMeta();
/* 142 */     metapick9.addEnchant(Enchantment.DURABILITY, 300, true);
/* 143 */     metapick9.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 3, true);
/* 144 */     metapick9.setDisplayName("§9Un pantalon très long");
/* 145 */     metapick9.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 146 */     metapick9.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 147 */     is9.setItemMeta(metapick9);
/* 148 */     return is9;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item10()
/*     */   {
/* 155 */     ItemStack is10 = new ItemStack(Material.GOLD_BOOTS, 1);
/* 156 */     ItemMeta metapick10 = is10.getItemMeta();
/* 157 */     metapick10.addEnchant(Enchantment.DIG_SPEED, 6, true);
/* 158 */     metapick10.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
/* 159 */     metapick10.setDisplayName("§6Une paire de botte intéressante c:");
/* 160 */     metapick10.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 161 */     metapick10.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 162 */     is10.setItemMeta(metapick10);
/* 163 */     return is10;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item11()
/*     */   {
/* 170 */     ItemStack is11 = new ItemStack(Material.STONE_AXE, 1);
/* 171 */     ItemMeta metapick11 = is11.getItemMeta();
/* 172 */     metapick11.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
/* 173 */     metapick11.setDisplayName("§cHache incendiaire <:(");
/* 174 */     metapick11.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 175 */     metapick11.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 176 */     is11.setItemMeta(metapick11);
/* 177 */     return is11;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item12()
/*     */   {
/* 184 */     ItemStack is12 = new ItemStack(Material.GOLD_LEGGINGS, 1);
/* 185 */     ItemMeta metapick12 = is12.getItemMeta();
/* 186 */     metapick12.addEnchant(Enchantment.DURABILITY, 300, true);
/* 187 */     metapick12.addEnchant(Enchantment.PROTECTION_FIRE, 2, true);
/* 188 */     metapick12.setDisplayName("§6Pantalon anti-incendiaire >:)");
/* 189 */     metapick12.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 190 */     metapick12.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 191 */     is12.setItemMeta(metapick12);
/* 192 */     return is12;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item13()
/*     */   {
/* 199 */     ItemStack is13 = new ItemStack(Material.APPLE, 1);
/* 200 */     ItemMeta metapick13 = is13.getItemMeta();
/* 201 */     metapick13.setDisplayName("§cUne pomme :o");
/* 202 */     metapick13.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 203 */     metapick13.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 204 */     is13.setItemMeta(metapick13);
/* 205 */     return is13;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item14()
/*     */   {
/* 212 */     ItemStack is14 = new ItemStack(Material.GRILLED_PORK, 1);
/* 213 */     ItemMeta metapick14 = is14.getItemMeta();
/* 214 */     metapick14.setDisplayName("§ede quoi te rassasier =)");
/* 215 */     metapick14.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 216 */     metapick14.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 217 */     is14.setItemMeta(metapick14);
/* 218 */     return is14;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemStack item15()
/*     */   {
/* 225 */     ItemStack is15 = new ItemStack(Material.DIRT, 1);
/* 226 */     ItemMeta metapick15 = is15.getItemMeta();
/* 227 */     metapick15.setDisplayName("§bde la terre enchanté '-'");
/* 228 */     metapick15.addEnchant(Enchantment.KNOCKBACK, 5, true);
/* 229 */     metapick15.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 230 */     metapick15.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_UNBREAKABLE });
/* 231 */     is15.setItemMeta(metapick15);
/* 232 */     return is15;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void OnBreak(BlockBreakEvent e)
/*     */   {
/* 250 */     Player p = e.getPlayer();
/* 251 */     Block b = e.getBlock();
/* 252 */     World world = Bukkit.getWorld("world");
/* 253 */     Location loc = p.getLocation();
/* 254 */     if (b.getType().equals(Material.QUARTZ_ORE))
/*     */     {
/* 256 */       e.setCancelled(true);
/* 257 */       b.setType(Material.AIR);
/*     */       
/*     */ 
/* 260 */       int r = new Random().nextInt(15);
/*     */       
/* 262 */       switch (r) {
/*     */       case 0: 
/* 264 */         world.dropItemNaturally(loc, item1());
/* 265 */         break;
/*     */       case 1: 
/* 267 */         world.dropItemNaturally(loc, item2());
/* 268 */         break;
/*     */       case 2: 
/* 270 */         world.dropItemNaturally(loc, item3());
/* 271 */         break;
/*     */       case 3: 
/* 273 */         world.dropItemNaturally(loc, item4());
/* 274 */         break;
/*     */       case 4: 
/* 276 */         world.dropItemNaturally(loc, item5());
/* 277 */         break;
/*     */       case 5: 
/* 279 */         world.dropItemNaturally(loc, item6());
/* 280 */         break;
/*     */       case 6: 
/* 282 */         world.dropItemNaturally(loc, item7());
/* 283 */         break;
/*     */       case 7: 
/* 285 */         world.dropItemNaturally(loc, item8());
/* 286 */         break;
/*     */       case 8: 
/* 288 */         world.dropItemNaturally(loc, item9());
/* 289 */         break;
/*     */       case 9: 
/* 291 */         world.dropItemNaturally(loc, item10());
/* 292 */         break;
/*     */       case 10: 
/* 294 */         world.dropItemNaturally(loc, item11());
/* 295 */         break;
/*     */       case 11: 
/* 297 */         world.dropItemNaturally(loc, item12());
/* 298 */         break;
/*     */       case 12: 
/* 300 */         world.dropItemNaturally(loc, item13());
/* 301 */         break;
/*     */       case 13: 
/* 303 */         world.dropItemNaturally(loc, item14());
/* 304 */         break;
/*     */       case 14: 
/* 306 */         world.dropItemNaturally(loc, item15());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\utils\Luckyblock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */