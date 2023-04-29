/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DBUtils;

/**
 *
 * @author Walking Bag
 */
public class noteDAO {

    public List<noteDTO> list(Long userID) {
        ArrayList<noteDTO> list;
        list = new ArrayList<noteDTO>();

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "SELECT id, userid, title, noteInfo, content, timestamp "
                + "FROM notetaking "
                + "WHERE userid = ?";

        try {
            con = DBUtils.getConnection();

            if (con != null) {

                stm = con.prepareStatement(sql);

                stm.setLong(1, userID);
                rs = stm.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int userid = rs.getInt("userid");
                    String title = rs.getString("title");
                    String noteInfo = rs.getString("noteInfo");
                    String content = rs.getString("content");
                    Date timestamp = rs.getDate("timestamp");

                    noteDTO note = new noteDTO(id, userid, title, noteInfo, content, timestamp);

                    list.add(note);
                }
                return list;
            }
        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return null;
    }

    public noteDTO load(Long id) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "SELECT id, userid, title, content "
                + "FROM notetaking "
                + "WHERE id = ?";

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                stm = con.prepareStatement(sql);

                stm.setLong(1, id);
                rs = stm.executeQuery();

                if (rs.next()) {
                    id = rs.getLong("id");
                    Long userid = rs.getLong("userid");
                    String title = rs.getString("title");
                    String content = rs.getString("content");

                    noteDTO note = new noteDTO(id, userid, title, content);
                    //Establish each variable before returning the note.
                    return note;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return null;
    }

    public boolean add(noteDTO note) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "INSERT INTO notetaking(userid, title, noteInfo) "
                + "VALUES (?,?,?)";

        try {

            con = DBUtils.getConnection();

            if (con != null) {
                stm = con.prepareStatement(sql);

                stm.setLong(1, note.getUserid());
                System.out.println("userID: " + note.getUserid());
                stm.setString(2, note.getTitle());
                stm.setString(3, note.getNoteInfo());

                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return false;
    }

    public boolean delete(Long id) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "DELETE FROM notetaking "
                + "WHERE id = ?";

        try {
            con = DBUtils.getConnection();

            if (con != null) {
                stm = con.prepareStatement(sql);

                stm.setLong(1, id);

                int effectRows = stm.executeUpdate();
                if (effectRows > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return false;
    }

    //Update the content of the note.
    public boolean updateNote(noteDTO note) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "UPDATE notetaking "
                + "SET title = ?, content = ? "
                + "WHERE id = ?";

        try {

            con = DBUtils.getConnection();

            if (con != null) {
                stm = con.prepareStatement(sql);

                stm.setString(1,note.getTitle());
                stm.setString(2, note.getContent());
                stm.setLong(3, note.getId());

                int effectRows = stm.executeUpdate();

                if (effectRows > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return false;
    }

    //Update on the small info of the note
    public boolean updateNoteInfo(noteDTO note) {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        String sql = "UPDATE notetaking "
                + "SET title = ?, noteInfo = ? "
                + "WHERE id = ?";

        try {

            con = DBUtils.getConnection();

            if (con != null) {
                stm = con.prepareStatement(sql);

                stm.setString(1, note.getTitle());
                stm.setString(2, note.getNoteInfo());
                stm.setLong(3, note.getId());

                int effectRows = stm.executeUpdate();

                if (effectRows > 0) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            System.out.println("Query note error!" + ex.getMessage());
        }
        return false;
    }

    //Create a list where it held search note list.
    private List<noteDTO> noteInfoList;

    public List<noteDTO> getNoteInfoList() {
        return noteInfoList;
    }

    public void search(String searchValue, Long userID) {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, userid, title, noteinfo, content, timestamp "
                        + "FROM notetaking "
                        + "WHERE title LIKE ? AND userid = ?";

                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                stm.setLong(2, userID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String title = rs.getString("title");
                    String noteinfo = rs.getString("noteinfo");
                    Date timestamp = rs.getDate("timestamp");
                    String content = rs.getString("content");
                    long id = rs.getLong("id");
                    long userid = rs.getLong("userid");

                    noteDTO dto = new noteDTO(id, userid, title, noteinfo, content, timestamp);

                    if (this.noteInfoList == null) {
                        this.noteInfoList = new ArrayList<>();
                    }
                    this.noteInfoList.add(dto);
                    //Add founded notes to list.
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
