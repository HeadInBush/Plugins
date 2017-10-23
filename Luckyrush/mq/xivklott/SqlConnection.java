/*     */ package mq.xivklott;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ public class SqlConnection
/*     */ {
/*     */   private Connection connection;
/*     */   private String urlbase;
/*     */   private String host;
/*     */   private String database;
/*     */   private String user;
/*     */   private String pass;
/*     */   
/*     */   public SqlConnection(String urlbase, String host, String database, String user, String pass)
/*     */   {
/*  19 */     this.urlbase = urlbase;
/*  20 */     this.host = host;
/*  21 */     this.database = database;
/*  22 */     this.user = user;
/*  23 */     this.pass = pass;
/*     */   }
/*     */   
/*     */   public void connection() {
/*  27 */     if (!isConnected()) {
/*     */       try {
/*  29 */         this.connection = java.sql.DriverManager.getConnection(this.urlbase + this.host + "/" + this.database, this.user, this.pass);
/*  30 */         System.out.println("connected ok");
/*     */       } catch (SQLException e) {
/*  32 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void disconnect() {
/*  38 */     if (isConnected()) {
/*     */       try {
/*  40 */         this.connection.close();
/*  41 */         System.out.println("connected off");
/*     */       } catch (SQLException e) {
/*  43 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isConnected()
/*     */   {
/*  51 */     return this.connection != null;
/*     */   }
/*     */   
/*     */   public void createAccount(Player player) {
/*  55 */     if (!hasAccount(player))
/*     */     {
/*     */       try
/*     */       {
/*  59 */         PreparedStatement q = this.connection.prepareStatement("INSERT INTO joueurs(uuid,coins,grade,player) VALUES (?,?,?,?)");
/*  60 */         q.setString(1, player.getUniqueId().toString());
/*  61 */         q.setInt(2, 100);
/*  62 */         q.setInt(3, Rank.Joueur.getPower());
/*  63 */         q.setString(4, player.getName());
/*  64 */         q.execute();
/*  65 */         q.close();
/*     */       } catch (SQLException e) {
/*  67 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean hasAccount(Player player)
/*     */   {
/*     */     try
/*     */     {
/*  78 */       PreparedStatement q = this.connection.prepareStatement("SELECT uuid FROM joueurs WHERE uuid = ?");
/*  79 */       q.setString(1, player.getUniqueId().toString());
/*  80 */       java.sql.ResultSet resultat = q.executeQuery();
/*  81 */       boolean hasAccount = resultat.next();
/*  82 */       q.close();
/*  83 */       return hasAccount;
/*     */     } catch (SQLException e) {
/*  85 */       e.printStackTrace();
/*     */     }
/*     */     
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int getBalance(Player player)
/*     */   {
/*     */     try
/*     */     {
/*  95 */       PreparedStatement q = this.connection.prepareStatement("SELECT coins FROM joueurs WHERE uuid = ?");
/*  96 */       q.setString(1, player.getUniqueId().toString());
/*     */       
/*  98 */       int balance = 0;
/*  99 */       java.sql.ResultSet rs = q.executeQuery();
/*     */       
/* 101 */       while (rs.next()) {
/* 102 */         balance = rs.getInt("coins");
/*     */       }
/*     */       
/* 105 */       q.close();
/*     */       
/* 107 */       return balance;
/*     */     }
/*     */     catch (SQLException e) {
/* 110 */       e.printStackTrace();
/*     */     }
/*     */     
/* 113 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void addMoney(Player player, int amount)
/*     */   {
/* 119 */     int balance = getBalance(player);
/* 120 */     int newbalance = balance + amount;
/*     */     try
/*     */     {
/* 123 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/* 124 */       rs.setInt(1, newbalance);
/* 125 */       rs.setString(2, player.getUniqueId().toString());
/* 126 */       rs.executeUpdate();
/* 127 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 130 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void removeMoney(Player player, int amount)
/*     */   {
/* 138 */     int balance = getBalance(player);
/* 139 */     int newbalance = balance - amount;
/*     */     
/* 141 */     if (newbalance <= 0) {
/* 142 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 146 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/* 147 */       rs.setInt(1, newbalance);
/* 148 */       rs.setString(2, player.getUniqueId().toString());
/* 149 */       rs.executeUpdate();
/* 150 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 153 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRank(Player player, Rank rank)
/*     */   {
/*     */     try
/*     */     {
/* 161 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET grade = ? WHERE uuid = ?");
/* 162 */       rs.setInt(1, rank.getPower());
/* 163 */       rs.setString(2, player.getUniqueId().toString());
/* 164 */       rs.executeUpdate();
/* 165 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 168 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Rank getRank(Player player)
/*     */   {
/*     */     try
/*     */     {
/* 177 */       PreparedStatement q = this.connection.prepareStatement("SELECT grade FROM joueurs WHERE uuid = ?");
/* 178 */       q.setString(1, player.getUniqueId().toString());
/*     */       
/* 180 */       int power = 0;
/* 181 */       java.sql.ResultSet rs = q.executeQuery();
/*     */       
/* 183 */       while (rs.next()) {
/* 184 */         power = rs.getInt("grade");
/*     */       }
/*     */       
/* 187 */       q.close();
/*     */       
/* 189 */       return Rank.powerToRank(power);
/*     */     }
/*     */     catch (SQLException e) {
/* 192 */       e.printStackTrace();
/*     */     }
/*     */     
/* 195 */     return Rank.Joueur;
/*     */   }
/*     */   
/*     */   public boolean hasPermission(Player player, String permission)
/*     */   {
/*     */     try {
/* 201 */       PreparedStatement rs = this.connection.prepareStatement("SELECT permission FROM permissions WHERE uuid = ? and permission = ?");
/* 202 */       rs.setString(1, player.getUniqueId().toString());
/* 203 */       rs.setString(2, permission);
/* 204 */       java.sql.ResultSet resultat = rs.executeQuery();
/* 205 */       if ((resultat.next()) && 
/* 206 */         (permission.equals(resultat.getString("permission")))) {
/* 207 */         return true;
/*     */       }
/*     */       
/* 210 */       return false;
/*     */     }
/*     */     catch (SQLException e) {
/* 213 */       e.printStackTrace();
/*     */     }
/* 215 */     return false;
/*     */   }
/*     */   
/*     */   public void addPermission(Player player, String permission) {
/* 219 */     if (hasPermission(player, permission)) {
/* 220 */       return;
/*     */     }
/*     */     try {
/* 223 */       PreparedStatement rs = this.connection.prepareStatement("INSERT INTO permissions (uuid, permission) VALUES (?, ?)");
/* 224 */       rs.setString(1, player.getUniqueId().toString());
/* 225 */       rs.setString(2, permission);
/* 226 */       rs.executeUpdate();
/* 227 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 230 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePermission(Player player, String permission) {
/* 235 */     if (!hasPermission(player, permission)) {
/* 236 */       return;
/*     */     }
/*     */     try {
/* 239 */       PreparedStatement rs = this.connection.prepareStatement("DELETE FROM permissions WHERE uuid = ? and permission = ?");
/* 240 */       rs.setString(1, player.getUniqueId().toString());
/* 241 */       rs.setString(2, permission);
/* 242 */       rs.executeUpdate();
/* 243 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 246 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\luckyrush.jar!\mq\xivklott\SqlConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */