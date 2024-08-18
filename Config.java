package de.itsuhr.teamCastle.utils;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
public class Config {

    private FileConfiguration config;
    private File file;
    public Config(String name , File path){
        file = new File(path, name);
        if (!file.exists())
            path.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        config = new YamlConfiguration();
        try {
            config.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reload() {
        try {
            config.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public Object get(String path) {
        return config.get(path);
    }

    public void set(String path, Object object) {
        config.set(path, object);
    }

    public boolean contains(String path) {
        return config.contains(path);
    }

    public boolean isClear() {
        return config.getKeys(false).size() == 0;
    }

    public double getDouble(String path) {
        return config.getDouble(path);
    }

    public double getDouble(String path, double def) {
        return config.getDouble(path, def);
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public String getString(String path, String def) {
        return config.getString(path, def);
    }

    public int getInt(String path) {
        return config.getInt(path);
    }

    public int getInt(String path, int def) {
        return config.getInt(path, def);
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public boolean getBoolean(String path, boolean def) {
        return config.getBoolean(path, def);
    }

    public Location getLocation(String path) {
        return config.getLocation(path);
    }

    public Location getLocation(String path, Location def) {
        return config.getLocation(path, def);
    }

}
