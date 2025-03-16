package net.supiserver.play.magicStone.model.sp;

import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class SpBonus {
    private Map<SpItem, Map<String, Double>> sp_table;

    public SpBonus(Map<SpItem, Map<String, Double>> table){
        this.sp_table = table;
    }

    public Map<String,Double> getTable(ItemStack item){
        return sp_table.entrySet().stream()
                .filter(entry -> entry.getKey().match(item))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
    }

    public String toString() {
        StringBuilder res = new StringBuilder("[");

        for (Map.Entry<SpItem, Map<String, Double>> table : sp_table.entrySet()) {
            SpItem k = table.getKey();
            Map<String, Double> v = table.getValue();

            res.append(String.format("{item: %s, data: %s}, ", k.toString(), v.toString()));
        }

        if (res.length() > 1)res.setLength(res.length() - 2);

        res.append("]");
        return res.toString();
    }
}
