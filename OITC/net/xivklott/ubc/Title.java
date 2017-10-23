/*    */ package net.xivklott.ubc;
/*    */ 
/*    */ import net.minecraft.server.v1_8_R3.EntityPlayer;
/*    */ import net.minecraft.server.v1_8_R3.IChatBaseComponent;
/*    */ import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
/*    */ import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
/*    */ import net.minecraft.server.v1_8_R3.PlayerConnection;
/*    */ import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class Title
/*    */ {
/*    */   public static void sendTitle(Player player, String title, String subTitle, int ticks)
/*    */   {
/* 16 */     IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
/* 17 */     IChatBaseComponent chatsubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subTitle + "\"}");
/*    */     
/* 19 */     PacketPlayOutTitle titre = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
/* 20 */     PacketPlayOutTitle soustitre = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatsubTitle);
/*    */     
/* 22 */     ((CraftPlayer)player).getHandle().playerConnection.sendPacket(titre);
/* 23 */     ((CraftPlayer)player).getHandle().playerConnection.sendPacket(soustitre);
/*    */     
/* 25 */     sendTime(player, ticks);
/*    */   }
/*    */   
/*    */ 
/*    */   private static void sendTime(Player player, int ticks)
/*    */   {
/* 31 */     PacketPlayOutTitle p = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, null, 20, ticks, 20);
/* 32 */     ((CraftPlayer)player).getHandle().playerConnection.sendPacket(p);
/*    */   }
/*    */   
/*    */ 
/*    */   public static void sendActionBar(Player player, String message)
/*    */   {
/* 38 */     IChatBaseComponent actionBar = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
/* 39 */     net.minecraft.server.v1_8_R3.PacketPlayOutChat ab = new net.minecraft.server.v1_8_R3.PacketPlayOutChat(actionBar, (byte)2);
/* 40 */     ((CraftPlayer)player).getHandle().playerConnection.sendPacket(ab);
/*    */   }
/*    */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\ubc\Title.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */