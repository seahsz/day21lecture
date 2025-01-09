package vttp.paf.day21lecture.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.paf.day21lecture.model.Room;
import vttp.paf.day21lecture.utility.Sql;

@Repository
public class RoomRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Room> getRooms() {

        List<Room> result = new LinkedList<>();

        SqlRowSet rowSet = template.queryForRowSet(Sql.getAllRooms);

        while (rowSet.next()) {
            result.add(new Room(rowSet.getInt("id"), rowSet.getString("room_type"), rowSet.getFloat("price")));
        }

        return Collections.unmodifiableList(result);
    }
    
}
