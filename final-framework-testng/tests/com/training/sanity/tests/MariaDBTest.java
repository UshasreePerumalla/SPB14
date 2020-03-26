package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.CategoryBean;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class MariaDBTest {
	public static void main(String args[]) throws IOException {
    /*    List<LoginBean> list = getdata();
        
        Object[][] result = new Object[list.size()][]; 
        int count = 0; 
        for(LoginBean temp : list){
            Object[]  obj = new Object[2]; 
            obj[0] = temp.getUserName(); 
            obj[1] = temp.getPassword(); 
            
            result[count ++] = obj; 
        }
        
        System.out.println(result);
        for(Object[] a:result)
        {
            for(Object b: a)
                System.out.println(b);
        }
    }
        
        
    static List<LoginBean> getdata() throws IOException {
    Properties properties = new Properties();
    FileInputStream inStream = new FileInputStream("./resources/sql.properties");
    properties.load(inStream);
    String sql = properties.getProperty("get.logins"); 
   // String sql1 = properties.getProperty("get.category"); 
    GetConnection gc  = new GetConnection(); 
    List<LoginBean> list = null;
    try {
        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
        list = new ArrayList<LoginBean>(); 
        
        gc.rs1 = gc.ps1.executeQuery(); 
        
        while(gc.rs1.next()) {
        
            LoginBean temp = new LoginBean(); 
            temp.setUserName(gc.rs1.getString(1));
            temp.setPassword(gc.rs1.getString(2));
            list.add(temp); 
            
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return list; 
    }*/
  
    List<CategoryBean> list = getcategory();
    
    Object[][] res = new Object[list.size()][]; 
   int cnt =0;
    for(CategoryBean temp : list){
        Object[]  objt = new Object[4]; 
        objt[0] = temp.getCategoryName(); 
        objt[1] = temp.getDescription(); 
        objt[2] = temp.getMetatagTitle();
        objt[3] = temp.getMetatagDescription();
        
        res[cnt ++] = objt; 
    }
   
    System.out.println(res);
    for(Object[] o:res)
    {
        for(Object c: o)
            System.out.println(c);
    }
    }
    
    static List<CategoryBean> getcategory() throws IOException {
        Properties properties = new Properties();
        FileInputStream inStream = new FileInputStream("./resources/sql.properties");
        properties.load(inStream);
       // String sql = properties.getProperty("get.logins"); 
        String sql1 = properties.getProperty("get.category"); 
        GetConnection gc  = new GetConnection(); 
        List<CategoryBean> list = null;
        try {
            gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql1); 
            list = new ArrayList<CategoryBean>(); 
            
            gc.rs1 = gc.ps1.executeQuery(); 
            
            while(gc.rs1.next()) {
            
                CategoryBean temp = new CategoryBean(); 
                temp.setCategoryName(gc.rs1.getString(1));
                temp.setDescription(gc.rs1.getString(2));
                temp.setMetatagTitle(gc.rs1.getString(3));
                temp.setMetatagDescription(gc.rs1.getString(4));
                list.add(temp); 
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;   

    }

}


