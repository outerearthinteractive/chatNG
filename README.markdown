chatNG (a chat plugin that actually works)
==========================================


Building
========

Eclipse
-------
To build, just checkout the repository. You will require the following "User" libraries:

* Bukkit
* Vault

You can add these to your Eclipse installation by going to 'Window > Preferences > Java > Build Path' and adding them

You will also need to install the _m2eclipse_ plugin, which can be done from 'Help > Install New Software'. 

CLI
---
Building from CLI is much easier, all that is required is a working JDK and Maven installation.

* Compile Jar: mvn install
* Run tests: mvn test

Easy as 3.14159.


