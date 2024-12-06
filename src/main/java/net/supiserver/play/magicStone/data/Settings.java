package net.supiserver.play.magicStone.data;

import net.supiserver.play.magicStone.data.excel.BasicData;
import net.supiserver.play.magicStone.data.excel.ExcelManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Settings {
    private static int MAX_WEIGHT = 300000;
    private static int MAX_FORTUNE_LEVEL = 5;
    private static Set<Material> TARGET_BLOCKS = Set.of(
            Material.STONE,
            Material.ANDESITE,
            Material.DIORITE,
            Material.GRANITE,
            Material.TUFF,
            Material.CALCITE,
            Material.DEEPSLATE
    );
    private static Set<String> TARGET_WORLDS = Set.of("shigen");




    public static void reload(JavaPlugin plugin, ExcelManager em){
        FileConfiguration config = plugin.getConfig();

        List<String> blocks = config.getStringList("blocks");
        if(blocks.isEmpty()){
            blocks = List.of(   "STONE",
                    "ANDESITE",
                    "DIORITE",
                    "GRANITE",
                    "TUFF",
                    "CALCITE",
                    "DEEPSLATE");
        }
        TARGET_BLOCKS = blocks.stream().map(Material::valueOf).collect(Collectors.toSet());

        List<String> worlds = config.getStringList("worlds");
        TARGET_WORLDS = new HashSet<>(worlds);

        Map<BasicData,String> basicData = em.reloadBasicData();
        MAX_WEIGHT = (int)Double.parseDouble(basicData.get(BasicData.MAX_WEIGHT));
        MAX_FORTUNE_LEVEL = (int)Double.parseDouble(basicData.get(BasicData.MAX_FORTUNE_LEVEL));
    }

    public static int getMaxWeight(){
        return MAX_WEIGHT;
    }

    public static int getMaxFortuneLevel(){
        return MAX_FORTUNE_LEVEL;
    }

    public static Set<Material> getTargetBlocks(){
        return TARGET_BLOCKS;
    }

    public static Set<String> getTargetWorlds(){
        return TARGET_WORLDS;
    }
}