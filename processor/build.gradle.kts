apply {
    plugin("java-library")
    plugin("kotlin")
}

//// workaround for ClassNotFoundException: com.sun.source.util.TreeScanner
//testCompile 'org.checkerframework:compiler:2.1.5'


dependencies {
    compile(project(":runtime"))

    listOf("com.google.auto.service:auto-service:1.0-rc3",
            "com.squareup:javapoet:1.9.0"

    ).forEach { compile(it) }

    listOf(extra["dependencies.junit"],
            extra["dependencies.mockito"],
            extra["dependencies.assertj"],
            extra["dependencies.kotlinStdLib"],
            "com.google.testing.compile:compile-testing:0.10",
            "org.checkerframework:compiler:2.1.5" /* workaround for ClassNotFoundException: com.sun.source.util.TreeScanner */

    ).forEach { testCompile(it) }
}

