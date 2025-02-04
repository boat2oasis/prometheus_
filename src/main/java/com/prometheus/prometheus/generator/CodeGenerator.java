package com.prometheus.prometheus.generator;

import java.nio.file.Paths;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {

	private static final String url = "jdbc:mysql://localhost:3306/english_learning?useSSL=false&serverTimezone=UTC";

	private static final String username = "root";

	private static final String password = "root2024_2025";

	public static void main(String[] args) {
		FastAutoGenerator.create(url, username, password)
				.globalConfig(builder -> builder.author("Heisenberg")
						.outputDir(Paths.get(System.getProperty("user.dir")) + "/src/main/java")
						.commentDate("yyyy-MM-dd"))
				.packageConfig(builder -> builder.parent("com.prometheus.prometheus").entity("entity").mapper("mapper")
						.service("service").serviceImpl("service.impl").xml("mapper.xml"))
				// 添加表名称
				.strategyConfig((scanner, builder) -> builder.addInclude("words_sentence").entityBuilder().enableLombok()

						.build())
				.templateEngine(new FreemarkerTemplateEngine()).execute();
	}
}