game-result-manager
===================

Library to store and retrieve the results of the games in your homework projects. 

## Download

Add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>hu.unideb.inf</groupId>
    <artifactId>game-result-manager</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

The artifact can be downloaded from [GitHub Packages](https://docs.github.com/en/packages) that requires the following element to be added to your `pom.xml` file:

```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/INBPM0420L/game-result-manager</url>
    </repository>
</repositories>
```

Note that GitHub Packages requires authentication using a personal access token (classic) that can be created [here](https://github.com/settings/tokens).

> [!IMPORTANT]
> You must create a personal access token (PAT) with the `read:packages` scope.

Your PAT must be kept in a [`settings.xml`](https://maven.apache.org/settings.html) file as follows:

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <servers>
        <server>
            <id>github</id>
            <username><!-- Your GitHub username --></username>
            <password><!-- Your GitHub personal access token (classic) --></password>
        </server>
    </servers>
</settings>
```

The `settings.xml` file must be placed in the `.m2` directory in your home directory, i.e., in the same directory that stores your local Maven repository.
