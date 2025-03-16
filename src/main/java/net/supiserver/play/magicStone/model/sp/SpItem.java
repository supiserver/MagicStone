package net.supiserver.play.magicStone.model.sp;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpItem {
    private final Material mate;
    private final String name;
    private final int custom_model;

    public SpItem(Material mate, String name, int custom_model){
        this.mate = mate;
        this.name = name;
        this.custom_model = custom_model;
    }

    public boolean match(ItemStack item){
        if(item==null || (mate!=null && !mate.equals(item.getType())))return false;

        ItemMeta meta = item.getItemMeta();
        if(meta==null) return name==null&&custom_model==-1;
        return (name==null || name.equals(meta.getItemName())) && (custom_model==-1 || custom_model==meta.getCustomModelData());
    }

    public String toString(){
        return String.format("{mate:%s,name:%s,custom_model:%d}",mate.toString(),name,custom_model);
    }
}
