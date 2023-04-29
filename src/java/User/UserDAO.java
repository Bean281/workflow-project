/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CCLaptop
 */
public class UserDAO {
        public UserDTO login(String user, String password){
        
        String sql = "select id, username, password, fullname, email from users "
                + " where username = ? and password = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, user);
            ps.setString(2, password);
            
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                UserDTO userDTO =  new UserDTO();
                
                userDTO.setUsername(rs.getString("username"));
                userDTO.setPassword(rs.getString("password"));
                userDTO.setId(rs.getLong("id"));
                userDTO.setEmail(rs.getString("email"));
                userDTO.setFullname(rs.getString("fullname"));
                
                
                return userDTO;
                
            }
        }
        catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return null;
    }
    
    public boolean signUp (UserDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Insert Into users("
                        + "username, password, fullname, email"
                        + ") Values ("
                        + "?, ?, ?, ?"
                        + ")";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getFullname());
                stm.setString(4, dto.getEmail());
                
                int effectRows = stm.executeUpdate();
                
                if (effectRows > 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean checkDuplicateUsername (String username) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        
        try {
             con = DBUtils.getConnection();
             if (con != null) {
                 String sql = "Select username from users where username = ?";
                 
                 stm = con.prepareStatement(sql);
                 stm.setString(1, username);
                 
                 rs = stm.executeQuery();
                 
                 if (rs.next()) {
                     result = true;
                 }
                 
             }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public boolean emailValidator(String email) {
        String EMAIL_PATTERN = 
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
               +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        
    }
    
    public boolean updateInfo(Long id, String username, String fullname, String password, String email) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Update users "
                        + "Set username = ?, fullname = ?, password = ?, email = ? "
                        + "Where id = ?";
                
                stm = con.prepareStatement(sql);
                
                stm.setString(1, username);
                stm.setString(2, fullname);
                stm.setString(3, password);
                stm.setString(4, email);
                stm.setLong(5, id);
                
                int effectRows = stm.executeUpdate();
                
                if (effectRows >= 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public boolean deleteAccouont (Long id) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        boolean result = false;
        
        try {
            con = DBUtils.getConnection();
            
            if (con != null) {
                String sql = "Delete from users "
                        + "Where id = ?";
                
                stm = con.prepareStatement(sql);
                stm.setLong(1, id);
                
                int effectRows = stm.executeUpdate();
                if (effectRows >= 0) {
                    result = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
    
    public UserDTO load(Long id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.getConnection();
            
            if (con != null) {
                String sql = "select id, username, password, fullname, email from users "
                + " where id = ?";
                
                stm = con.prepareStatement(sql);
                stm.setLong(1, id);
                
                rs = stm.executeQuery();
                
                if (rs.next()) {
                    return new UserDTO(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("fullname"),
                            rs.getString("email")
                    );
                }
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
