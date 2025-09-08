package com.algorithm.common.component;

import java.nio.file.Path;
import java.util.List;

public class ResourceHandler {
    private static final Path PATH = Path.of("src/main/resources/baekjoon/problem");

    public static boolean isParseSampleData(String name) {
        Path targetPath = PATH.resolve(name);
        return targetPath.toFile().exists();
    }

    public static void createDirectory(String name) {
        Path targetPath = PATH.resolve(name);
        if (!targetPath.toFile().exists()) {
            boolean isCreate = targetPath.toFile().mkdirs();
            System.out.println(isCreate);
        }
    }

    public static void createFile(String dirName, String fileName) {
        Path targetPath = PATH.resolve(dirName).resolve(fileName);
        if (!targetPath.toFile().exists()) {
            try {
                targetPath.toFile().createNewFile();
            } catch (Exception e) {
                throw new RuntimeException("Fail to create file.");
            }
        }
    }

    public static void writeToFile(String dirName, String fileName, String content) {
        Path targetPath = PATH.resolve(dirName).resolve(fileName);
        try (java.io.FileWriter writer = new java.io.FileWriter(targetPath.toFile())) {
            writer.write(content);
        } catch (Exception e) {
            throw new RuntimeException("Fail to write file.");
        }
    }

    public static String readFromFile(String dirName, String fileName) {
        Path targetPath = PATH.resolve(dirName).resolve(fileName);
        try {
            return java.nio.file.Files.readString(targetPath);
        } catch (Exception e) {
            throw new RuntimeException("Fail to read file.");
        }
    }

    public static List<String> listFileNames(String dirName) {
        Path targetPath = PATH.resolve(dirName);
        try (var stream = java.nio.file.Files.list(targetPath)) {
            return stream
                    .filter(java.nio.file.Files::isRegularFile)
                    .map(path -> path.getFileName().toString())
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Fail to list files.");
        }
    }

}
