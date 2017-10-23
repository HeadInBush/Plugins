/*    */ package net.xivklott.ubc;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.event.Listener;
/*    */ 
/*    */ public enum Rank
/*    */   implements Listener
/*    */ {
/* 11 */   Joueur(10, "§7  ", ChatColor.GRAY), 
/* 12 */   Vip(20, "§eVIP ", ChatColor.YELLOW), 
/* 13 */   MegaVip(30, "§aVIP+ ", ChatColor.GREEN), 
/* 14 */   Origins(40, "§3Origins ", ChatColor.DARK_AQUA), 
/* 15 */   Guide(50, "§5Guide", ChatColor.DARK_PURPLE), 
/* 16 */   Modo(60, "§1Modo ", ChatColor.DARK_GREEN), 
/* 17 */   GameDesigner(70, "§6GameDesigner ", ChatColor.GOLD), 
/* 18 */   Dev(80, "§bDéveloppeur ", ChatColor.AQUA), 
/* 19 */   Admin(90, "§cAdministrateur ", ChatColor.RED), 
/* 20 */   Fondateur(100, "§4Fondateur ", ChatColor.RED);
/*    */   
/*    */ 
/*    */   private int power;
/*    */   private String displayName;
/*    */   private ChatColor colorTag;
/*    */   public static Map<Integer, Rank> grade;
/*    */   
/*    */   private Rank(int power, String displayName, ChatColor tag)
/*    */   {
/* 30 */     this.power = power;
/* 31 */     this.displayName = displayName;
/* 32 */     this.colorTag = tag;
/*    */   }
/*    */   
/*    */   static
/*    */   {
/* 27 */     grade = new HashMap();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     Rank[] arrayOfRank;
/*    */     
/*    */ 
/*    */ 
/* 36 */     int j = (arrayOfRank = values()).length; for (int i = 0; i < j; i++) { Rank r = arrayOfRank[i];
/* 37 */       grade.put(Integer.valueOf(r.getPower()), r);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getPower() {
/* 42 */     return this.power;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 46 */     return this.displayName;
/*    */   }
/*    */   
/*    */   public ChatColor getTag() {
/* 50 */     return this.colorTag;
/*    */   }
/*    */   
/*    */   public static Rank powerToRank(int power) {
/* 54 */     return (Rank)grade.get(Integer.valueOf(power));
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\ubc\Rank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */