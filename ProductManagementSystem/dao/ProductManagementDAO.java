package dao;

import dbutil.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pojo.Product;

public class ProductManagementDAO {
public ProductManagementDAO() {
}

public static List<Product> getAllProducts() {
   List<Product> productList = new ArrayList();

   try {
      Connection conn = DBUtil.getConnection();
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM product");

      while(rs.next()) {
         Product product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getString("prod_category"), rs.getInt("prod_price"));
         productList.add(product);
      }

      DBUtil.closeConnection(conn);
   } catch (Exception var5) {
      var5.printStackTrace();
   }

   return productList;
}

public static Product getProductById(String productId) {
   Product product = null;

   try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
      ps.setString(1, productId);

      for(ResultSet rs = ps.executeQuery(); rs.next(); product = new Product(rs.getString("prod_id"), rs.getString("prod_name"), rs.getString("prod_category"), rs.getInt("prod_price"))) {
      }
   } catch (Exception var5) {
      var5.printStackTrace();
   }

   return product;
}

public static int addProduct(Product product) {
   int status = 0;

   try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?)");
      ps.setString(1, product.getProductId());
      ps.setString(2, product.getProductName());
      ps.setString(3, product.getProductCategory());
      ps.setInt(4, product.getProductPrice());
      status = ps.executeUpdate();
   } catch (Exception var4) {
      var4.printStackTrace();
   }

   return status;
}

public static int updateProduct(Product product) {
   int status = 0;

   try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement("UPDATE product SET prod_name=?, prod_category=?, prod_price=? WHERE prod_id=?");
      ps.setString(1, product.getProductName());
      ps.setString(2, product.getProductCategory());
      ps.setInt(3, product.getProductPrice());
      ps.setString(4, product.getProductId());
      status = ps.executeUpdate();
   } catch (Exception var4) {
      var4.printStackTrace();
   }

   return status;
}

public static int deleteProduct(String productId) {
   int status = 0;

   try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement("DELETE FROM product where prod_id = ?");
      ps.setString(1, productId);
      status = ps.executeUpdate();
   } catch (Exception var4) {
      var4.printStackTrace();
   }

   return status;
}
}
