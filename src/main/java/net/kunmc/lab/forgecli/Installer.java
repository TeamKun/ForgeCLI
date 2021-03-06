package net.kunmc.lab.forgecli;

import java.io.File;

import net.minecraftforge.installer.actions.ProgressCallback;

public class Installer {
    public static boolean install(File target, File installerJar) {
        ProgressCallback monitor = ProgressCallback.withOutputs(System.out);
        if (System.getProperty("java.net.preferIPv4Stack") == null) {
            System.setProperty("java.net.preferIPv4Stack", "true");
        }
        String vendor = System.getProperty("java.vendor", "missing vendor");
        String javaVersion = System.getProperty("java.version", "missing java version");
        String jvmVersion = System.getProperty("java.vm.version", "missing jvm version");
        monitor.message(String.format("JVM info: %s - %s - %s", vendor, javaVersion, jvmVersion));
        monitor.message("java.net.preferIPv4Stack=" + System.getProperty("java.net.preferIPv4Stack"));
        return InstallerUtil.runClientInstall(monitor, target, installerJar);
    }
}
