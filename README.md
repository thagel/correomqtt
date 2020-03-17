[![Build Status](https://travis-ci.org/exxeta/correomqtt.svg?branch=develop)](https://travis-ci.org/exxeta/correomqtt) 
[![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/exxeta/correomqtt?include_prereleases)](https://github.com/exxeta/correomqtt/releases/latest) 
[![GitHub All Releases](https://img.shields.io/github/downloads/exxeta/correomqtt/total)](https://github.com/exxeta/correomqtt/releases/latest) 
[![GitHub](https://img.shields.io/github/license/exxeta/correomqtt)](https://github.com/exxeta/correomqtt/blob/develop/LICENSE) 

# CorreoMQTT
A modern graphical MQTT client using the HiveMQ client library.


## Binary Downloads

* Release: https://github.com/EXXETA/correomqtt/releases/latest

**Note for OSX**: Due to gatekeeper it is required to allow CorreoMQTT. This can be done like this:
`xattr -d com.apple.quarantine /Applications/CorreoMQTT.app`

## Screenshot

![CorreoMQTT Connection View](screenshot.png)

## Developement

Feel free to contribute. Check out our project board with open issues here: https://github.com/orgs/EXXETA/projects/2

## Prerequisites

* Install Java 13 e.g. from here https://www.azul.com/downloads/zulu-community/ (Note: No JavaFX is required, as it is handled via maven)
* Install Jpackage, if you want to build native installers: https://jdk.java.net/jpackage/

## Build app
`mvn clean package`

## Run jars

`java -jar target/shade/correomqtt.jar`

## Plugins

* [Learn how to use plugins](https://github.com/EXXETA/correomqtt/wiki/Using-Plugins)
* [Learn how to create plugins](https://github.com/EXXETA/correomqtt/wiki/Create-a-Plugin)

## Licence 

Licensed under GPL v3.0.
