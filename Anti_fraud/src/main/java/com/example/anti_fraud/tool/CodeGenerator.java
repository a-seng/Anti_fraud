package com.example.anti_fraud.tool;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import java.util.Collections;
import java.nio.file.Paths;
public class CodeGenerator {

    public static void main(String[] args) {
        // 构建正确的输出目录路径
        String outputDir = Paths.get("C:", "Users", "86182", "OneDrive", "桌面", "Spring_V", "Anti_fraud", "src", "main", "java").toString();
        String xmlOutputDir = Paths.get("C:", "Users", "86182", "OneDrive", "桌面", "Spring_V", "Anti_fraud", "src", "main", "resources", "mapper").toString();

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/anti_fraud?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC", "root", "root")
                .globalConfig(builder -> {
                    builder.author("Your Name") // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(outputDir); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.anti_fraud") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, xmlOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok() // 启用lombok模型
                            .controllerBuilder().enableRestStyle(); // 开启生成@RestController控制器
                    // 不再使用.addInclude()，自动包含所有表
                })
                .execute();
    }
}
