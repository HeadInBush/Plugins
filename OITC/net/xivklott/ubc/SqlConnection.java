/*     */ package net.xivklott.ubc;
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
/*  30 */         System.out.println("connexion effectuer avec la bdd");
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
/*  41 */         System.out.println("connexion fermer");
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
/*  55 */     if (!hasAccount(player)) {
/*     */       try {
/*  57 */         PreparedStatement q = this.connection.prepareStatement("INSERT INTO joueurs(uuid,coins,grade,player) VALUES (?,?,?,?)");
/*  58 */         q.setString(1, player.getUniqueId().toString());
/*  59 */         q.setInt(2, 100);
/*  60 */         q.setInt(3, Rank.Joueur.getPower());
/*  61 */         q.setString(4, player.getName());
/*  62 */         q.execute();
/*  63 */         q.close();
/*     */       } catch (SQLException e) {
/*  65 */         e.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean hasAccount(Player player)
/*     */   {
/*     */     try
/*     */     {
/*  74 */       PreparedStatement q = this.connection.prepareStatement("SELECT uuid FROM joueurs WHERE uuid = ?");
/*  75 */       q.setString(1, player.getUniqueId().toString());
/*  76 */       java.sql.ResultSet resultat = q.executeQuery();
/*  77 */       boolean hasAccount = resultat.next();
/*  78 */       q.close();
/*  79 */       return hasAccount;
/*     */     } catch (SQLException e) {
/*  81 */       e.printStackTrace();
/*     */     }
/*     */     
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int getBalance(Player player) {
/*     */     try {
/*  89 */       PreparedStatement q = this.connection.prepareStatement("SELECT coins FROM joueurs WHERE uuid = ?");
/*  90 */       q.setString(1, player.getUniqueId().toString());
/*     */       
/*  92 */       int balance = 0;
/*  93 */       java.sql.ResultSet rs = q.executeQuery();
/*     */       
/*  95 */       while (rs.next()) {
/*  96 */         balance = rs.getInt("coins");
/*     */       }
/*     */       
/*  99 */       q.close();
/*     */       
/* 101 */       return balance;
/*     */     }
/*     */     catch (SQLException e) {
/* 104 */       e.printStackTrace();
/*     */     }
/*     */     
/* 107 */     return 0;
/*     */   }
/*     */   
/*     */   public void addMoney(Player player, int amount) {
/* 111 */     int balance = getBalance(player);
/* 112 */     int newbalance = balance + amount;
/*     */     try
/*     */     {
/* 115 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/* 116 */       rs.setInt(1, newbalance);
/* 117 */       rs.setString(2, player.getUniqueId().toString());
/* 118 */       rs.executeUpdate();
/* 119 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 122 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeMoney(Player player, int amount)
/*     */   {
/* 128 */     int balance = getBalance(player);
/* 129 */     int newbalance = balance - amount;
/*     */     
/* 131 */     if (newbalance <= 0) {
/* 132 */       return;
/*     */     }
/*     */     try
/*     */     {
/* 136 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET coins = ? WHERE uuid = ?");
/* 137 */       rs.setInt(1, newbalance);
/* 138 */       rs.setString(2, player.getUniqueId().toString());
/* 139 */       rs.executeUpdate();
/* 140 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 143 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setRank(Player player, Rank rank)
/*     */   {
/*     */     try {
/* 150 */       PreparedStatement rs = this.connection.prepareStatement("UPDATE joueurs SET grade = ? WHERE uuid = ?");
/* 151 */       rs.setInt(1, rank.getPower());
/* 152 */       rs.setString(2, player.getUniqueId().toString());
/* 153 */       rs.executeUpdate();
/* 154 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 157 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Rank getRank(Player player)
/*     */   {
/*     */     try
/*     */     {
/* 166 */       PreparedStatement q = this.connection.prepareStatement("SELECT grade FROM joueurs WHERE uuid = ?");
/* 167 */       q.setString(1, player.getUniqueId().toString());
/*     */       
/* 169 */       int power = 0;
/* 170 */       java.sql.ResultSet rs = q.executeQuery();
/*     */       
/* 172 */       while (rs.next()) {
/* 173 */         power = rs.getInt("grade");
/*     */       }
/*     */       
/* 176 */       q.close();
/*     */       
/* 178 */       return Rank.powerToRank(power);
/*     */     }
/*     */     catch (SQLException e) {
/* 181 */       e.printStackTrace();
/*     */     }
/*     */     
/* 184 */     return Rank.Joueur;
/*     */   }
/*     */   
/*     */   public boolean hasPermission(Player player, String permission)
/*     */   {
/*     */     try {
/* 190 */       PreparedStatement rs = this.connection.prepareStatement("SELECT permission FROM permissions WHERE uuid = ? and permission = ?");
/* 191 */       rs.setString(1, player.getUniqueId().toString());
/* 192 */       rs.setString(2, permission);
/* 193 */       java.sql.ResultSet resultat = rs.executeQuery();
/* 194 */       if ((resultat.next()) && 
/* 195 */         (permission.equals(resultat.getString("permission")))) {
/* 196 */         return true;
/*     */       }
/*     */       
/* 199 */       return false;
/*     */     }
/*     */     catch (SQLException e) {
/* 202 */       e.printStackTrace();
/*     */     }
/* 204 */     return false;
/*     */   }
/*     */   
/*     */   public void addPermission(Player player, String permission) {
/* 208 */     if (hasPermission(player, permission)) {
/* 209 */       return;
/*     */     }
/*     */     try {
/* 212 */       PreparedStatement rs = this.connection.prepareStatement("INSERT INTO permissions (uuid, permission) VALUES (?, ?)");
/* 213 */       rs.setString(1, player.getUniqueId().toString());
/* 214 */       rs.setString(2, permission);
/* 215 */       rs.executeUpdate();
/* 216 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 219 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public void removePermission(Player player, String permission) {
/* 224 */     if (!hasPermission(player, permission)) {
/* 225 */       return;
/*     */     }
/*     */     try {
/* 228 */       PreparedStatement rs = this.connection.prepareStatement("DELETE FROM permissions WHERE uuid = ? and permission = ?");
/* 229 */       rs.setString(1, player.getUniqueId().toString());
/* 230 */       rs.setString(2, permission);
/* 231 */       rs.executeUpdate();
/* 232 */       rs.close();
/*     */     }
/*     */     catch (SQLException e) {
/* 235 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\KuSh_Ozho\Desktop\truc a envoyer\oitc.jar!\net\xivklott\ubc\SqlConnection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */