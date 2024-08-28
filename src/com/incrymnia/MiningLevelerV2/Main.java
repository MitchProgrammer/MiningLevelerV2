package com.incrymnia.MiningLevelerV2;

public class Main {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

        // Register commands
        getCommand("setlevel").setExecutor(new SetLevelCommand());
        getCommand("setxp").setExecutor(new SetXpCommand());
        getCommand("addxp").setExecutor(new AddXpCommand());
        getCommand("removexp").setExecutor(new RemoveXpCommand());
        getCommand("top").setExecutor(new TopCommand());
        getCommand("togglexpmessages").setExecutor(new ToggleXpMessagesCommand());
        getCommand("level").setExecutor(new LevelCommand());
        getCommand("nextlevel").setExecutor(new NextLevelCommand());
        getCommand("xp").setExecutor(new XpCommand());
        getCommand("totalxp").setExecutor(new TotalXpCommand());

        // Register PlaceholderAPI expansion
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new MiningLevelingExpansion(this).register();
        }

        // Load configuration
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        PlayerData.saveAllPlayerData();
    }

    public static MiningLevelingPlugin getInstance() {
        return instance;
    }
}
