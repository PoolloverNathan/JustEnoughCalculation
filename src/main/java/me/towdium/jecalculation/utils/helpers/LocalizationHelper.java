package me.towdium.jecalculation.utils.helpers;

import me.towdium.jecalculation.utils.wrappers.Pair;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Author:  Towdium
 * Created: 2016/6/22.
 */
@SideOnly(Side.CLIENT)
public class LocalizationHelper {

    public static Pair<String, Boolean> search(String translateKey, Object... parameters) {
        Pair<String, Boolean> ret = new Pair<>(null, null);
        String buffer = I18n.format(translateKey, parameters);
        ret.two = !buffer.equals(translateKey);
        buffer = StringEscapeUtils.unescapeJava(buffer);
        ret.one = buffer.replace("\t", "    ");
        return ret;
    }

    public static String format(String translateKey, Object... parameters) {
        return search(translateKey, parameters).one;
    }
}
