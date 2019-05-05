import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.omg.CORBA.OBJ_ADAPTER;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: nautilis
 **/
public class Testttt {

    public static void main(String[] args) {
        byte[] data = new byte[2];
        data[0] = 0x30;
        data[1] = 0x35;
        String gbk = getString(data, 0, 2, "GBK");
        System.out.println(gbk);
        String sql = "SELECT " +
                " CASE WHEN mp.name IS NOT NULL AND mp.name != '' THEN " +
                " mb.value||'-'||mp.name " +
                " ELSE " +
                " mb.value||'-'||mp.locate " +
                " END locate, " +
                " mp.locate cargo, mp.name channelName,mp.isactive," +
                " mp.lyy_mainboard_position_id, m.lyy_material_id," +
                " m.name,mp.game_coins ,m.image_url,mp.status,mt.quantity,m.price,mp.game_price,mp.game_rate,mp.good_price,mp.game_times,mp.capacity " +
                " FROM lyy_mainboard mb JOIN lyy_mainboard_position mp ON mb.lyy_mainboard_id = mp.lyy_mainboard_id " +
                " LEFT JOIN lyy_equipment e ON mb.lyy_equipment_id = e.lyy_equipment_id AND mp.isactive = 'Y' " +
                " LEFT JOIN lyy_mainboard_position_material mt ON mp.lyy_mainboard_position_id = mt.lyy_mainboard_position_id " +
                " LEFT JOIN lyy_material m ON mt.lyy_material_id = m.lyy_material_id WHERE e.value = :value " +
                " ORDER BY mb.value,mp.locate ";
        System.out.println(sql);

    }

    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

    private static List<Map<String,Object>> getMapList(Map<String,Object> map, int blockSize) {
        List<String> locates = (List<String>) map.get("locates");
        List<Map<String,Object>> result = new ArrayList<>();
        int size = locates.size();
        if(size < blockSize) {
            result.add(map);
            return result;
        }
        int blockCount = size / blockSize;
        if (size % blockSize > 0) blockCount +=1;
        for(int i=1; i<=blockCount; i++ ) {
            List<String> newLocates = new ArrayList<>();
            Map<String,Object> newMap = new HashMap<>(map);
            if(i==blockCount) {
                newLocates = locates.subList((i-1) * 50, locates.size());
            } else {
                newLocates = locates.subList((i - 1) * 50, i * 50);
            }
            newMap.put("locates", newLocates);
            result.add(newMap);
        }
        return result;
    }

    public static void solution() {
        int x, y, z;
        for(x=1;x<5;x++) {
            for(y=1;y<5;y++) {
                for(z=1;z<5;z++) {
                    System.out.println(x * 100 + y * 10 + z);
                }
            }
        }
    }

    public static void testSub(BigDecimal d) {
        d.subtract(new BigDecimal(10));
    }

    public static String getString(byte[] source, int offset, int length, String decode){
        if (length == 0)
            return "";
        else {
            try {
                return new String(getBytes(source, offset, length), decode);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static byte[] getBytes(byte[] source, int offset, int length) {
        byte[] dest = new byte[length];
        System.arraycopy(source, offset, dest, 0, length);
        return dest;
    }

}
