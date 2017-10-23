/*     */ package mq.xivklott.luckyblocks;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mq.xivklott.utils.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ 
/*     */ public class Luckyblock implements org.bukkit.event.Listener
/*     */ {
/*     */   private Main main;
/*     */   
/*     */   public Luckyblock(Main main)
/*     */   {
/*  19 */     this.main = main;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void OnBreak(BlockBreakEvent e) {
/*  24 */     Player p = e.getPlayer();
/*  25 */     Block b = e.getBlock();
/*  26 */     if (b.getType() == this.main.luckyblock) {
/*  27 */       e.setCancelled(true);
/*  28 */       b.setType(Material.AIR);
/*     */       
/*  30 */       int r = new Random().nextInt(17);
/*     */       
/*  32 */       switch (r) {
/*     */       case 0: 
/*  34 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  35 */           this.main.getConfig().getString("cmd-add1")
/*  36 */           .replace("customcmd add", 
/*  37 */           this.main.getConfig().getString("cmd-replace-add1")) + 
/*  38 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  39 */           " " + this.main.getConfig().getString("loot-1"));
/*     */         
/*     */ 
/*     */ 
/*  43 */         break;
/*     */       case 1: 
/*  45 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  46 */           this.main.getConfig().getString("cmd-add2")
/*  47 */           .replace("customcmd add", 
/*  48 */           this.main.getConfig().getString("cmd-replace-add2")) + 
/*  49 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  50 */           " " + this.main.getConfig().getString("loot-2"));
/*  51 */         break;
/*     */       case 2: 
/*  53 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  54 */           this.main.getConfig().getString("cmd-add3")
/*  55 */           .replace("customcmd add", 
/*  56 */           this.main.getConfig().getString("cmd-replace-add3")) + 
/*  57 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  58 */           " " + this.main.getConfig().getString("loot-3"));
/*  59 */         break;
/*     */       case 3: 
/*  61 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  62 */           this.main.getConfig().getString("cmd-add4")
/*  63 */           .replace("customcmd add", 
/*  64 */           this.main.getConfig().getString("cmd-replace-add4")) + 
/*  65 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  66 */           " " + this.main.getConfig().getString("loot-4"));
/*  67 */         break;
/*     */       case 4: 
/*  69 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  70 */           this.main.getConfig().getString("cmd-add5")
/*  71 */           .replace("customcmd add", 
/*  72 */           this.main.getConfig().getString("cmd-replace-add5")) + 
/*  73 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  74 */           " " + this.main.getConfig().getString("loot-5"));
/*  75 */         break;
/*     */       case 5: 
/*  77 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  78 */           this.main.getConfig().getString("cmd-add6")
/*  79 */           .replace("customcmd add", 
/*  80 */           this.main.getConfig().getString("cmd-replace-add6")) + 
/*  81 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  82 */           " " + this.main.getConfig().getString("loot-6"));
/*  83 */         break;
/*     */       case 6: 
/*  85 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  86 */           this.main.getConfig().getString("cmd-add7")
/*  87 */           .replace("customcmd add", 
/*  88 */           this.main.getConfig().getString("cmd-replace-add7")) + 
/*  89 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  90 */           " " + this.main.getConfig().getString("loot-7"));
/*  91 */         break;
/*     */       case 7: 
/*  93 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/*  94 */           this.main.getConfig().getString("cmd-add8")
/*  95 */           .replace("customcmd add", 
/*  96 */           this.main.getConfig().getString("cmd-replace-add8")) + 
/*  97 */           " " + "%player%".replace("%player%", p.getName()) + 
/*  98 */           " " + this.main.getConfig().getString("loot-8"));
/*  99 */         break;
/*     */       case 8: 
/* 101 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 102 */           this.main.getConfig().getString("cmd-add9")
/* 103 */           .replace("customcmd add", 
/* 104 */           this.main.getConfig().getString("cmd-replace-add9")) + 
/* 105 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 106 */           " " + this.main.getConfig().getString("loot-9"));
/* 107 */         break;
/*     */       case 9: 
/* 109 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 110 */           this.main.getConfig().getString("cmd-add10")
/* 111 */           .replace("customcmd add", 
/* 112 */           this.main.getConfig().getString("cmd-replace-add10")) + 
/* 113 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 114 */           " " + this.main.getConfig().getString("loot-10"));
/* 115 */         break;
/*     */       case 10: 
/* 117 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 118 */           this.main.getConfig().getString("cmd-add11")
/* 119 */           .replace("customcmd add", 
/* 120 */           this.main.getConfig().getString("cmd-replace-add11")) + 
/* 121 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 122 */           " " + this.main.getConfig().getString("loot-11"));
/* 123 */         break;
/*     */       case 12: 
/* 125 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 126 */           this.main.getConfig().getString("cmd-add12")
/* 127 */           .replace("customcmd add", 
/* 128 */           this.main.getConfig().getString("cmd-replace-add12")) + 
/* 129 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 130 */           " " + this.main.getConfig().getString("loot-12"));
/* 131 */         break;
/*     */       case 13: 
/* 133 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 134 */           this.main.getConfig().getString("cmd-add13")
/* 135 */           .replace("customcmd add", 
/* 136 */           this.main.getConfig().getString("cmd-replace-add13")) + 
/* 137 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 138 */           " " + this.main.getConfig().getString("loot-13"));
/* 139 */         break;
/*     */       case 14: 
/* 141 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 142 */           this.main.getConfig().getString("cmd-add13")
/* 143 */           .replace("customcmd add", 
/* 144 */           this.main.getConfig().getString("cmd-replace-add13")) + 
/* 145 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 146 */           " " + this.main.getConfig().getString("loot-14"));
/* 147 */         break;
/*     */       case 15: 
/* 149 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 150 */           this.main.getConfig().getString("cmd-add14")
/* 151 */           .replace("customcmd add", 
/* 152 */           this.main.getConfig().getString("cmd-replace-add14")) + 
/* 153 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 154 */           " " + this.main.getConfig().getString("loot-14"));
/* 155 */         break;
/*     */       case 16: 
/* 157 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), 
/* 158 */           this.main.getConfig().getString("cmd-add15")
/* 159 */           .replace("customcmd add", 
/* 160 */           this.main.getConfig().getString("cmd-replace-add15")) + 
/* 161 */           " " + "%player%".replace("%player%", p.getName()) + 
/* 162 */           " " + this.main.getConfig().getString("loot-15"));
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\utilitaire.jar!\mq\xivklott\luckyblocks\Luckyblock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */