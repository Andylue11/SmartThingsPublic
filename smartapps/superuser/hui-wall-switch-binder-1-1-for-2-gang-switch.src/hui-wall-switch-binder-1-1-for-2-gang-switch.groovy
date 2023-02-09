/**
 *  HUI Wall Switch Binder original from Andy's SmartApp - shamlessly borrowed by the netsheriff and modded.
 *  This app allows you to bind 3 Virtual On/Off Tiles to the 3 switchable outlets.
 *
 *  Author: simic with mod by netsheriff
 *  Date: 05/09/2017
 */
// Automatically generated. Make future change here.
definition(
    name: "HUI Wall Switch Binder 1.1 for 2 Gang Switch",
    namespace: "",
    author: "netsheriff",
    description: "This app allows you to bind 2 Virtual On/Off Tiles to the 2 switchable outlets.",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience%402x.png")
preferences {
	section("Which HUI Wall Switch is used?"){
		input "strip", "capability.Switch"
	}
	section("Select a Virtual Switch to bind to Outlet 1"){
		input "switch1", "capability.Switch"
	}
    section("Select a Virtual Switch to bind to Outlet 2"){
		input "switch2", "capability.Switch"
	}
}
def installed() {
	log.debug "Installed with settings: ${settings}"
    subscribe(strip, "switch.on", MainSwitchOnOneHandler)
    subscribe(strip, "switch.off", MainSwitchOffOneHandler)
    subscribe(strip, "switch1.on", MainSwitchOnOneHandler)
    subscribe(strip, "switch1.off", MainSwitchOffOneHandler)
    subscribe(strip, "switch2.on", MainSwitchOnTwoHandler)
    subscribe(strip, "switch2.off", MainSwitchOffTwoHandler)
    
	subscribe(switch1, "switch.on", switchOnOneHandler)
    subscribe(switch2, "switch.on", switchOnTwoHandler)
    subscribe(switch1, "switch.off", switchOffOneHandler)
    subscribe(switch2, "switch.off", switchOffTwoHandler)
}
def updated(settings) {
	log.debug "Updated with settings: ${settings}"
	unsubscribe()
    subscribe(strip, "switch.on", MainSwitchOnOneHandler)
    subscribe(strip, "switch.off", MainSwitchOffOneHandler)
    
	subscribe(strip, "switch1.on", MainSwitchOnOneHandler)
    subscribe(strip, "switch1.off", MainSwitchOffOneHandler)
    
    subscribe(strip, "switch2.on", MainSwitchOnTwoHandler)
    subscribe(strip, "switch2.off", MainSwitchOffTwoHandler)

    subscribe(switch1, "switch.on", switchOnOneHandler)
    subscribe(switch2, "switch.on", switchOnTwoHandler)
    
    subscribe(switch1, "switch.off", switchOffOneHandler)
    subscribe(switch2, "switch.off", switchOffTwoHandler)
   }
def MainSwitchOnOneHandler(evt) {
	log.debug "switch on"
	switch1.on()
}
def MainSwitchOffOneHandler(evt) {
	log.debug "switch off"
	switch1.off()
}
def MainSwitchOnTwoHandler(evt) {
	log.debug "switch on"
	switch2.on()
}
def MainSwitchOffTwoHandler(evt) {
	log.debug "switch off"
	switch2.off()
}
def switchOnOneHandler(evt) {
	log.debug "switch on1"
	strip.on()
}
def switchOnTwoHandler(evt) {
	log.debug "switch on2"
	strip.on2()
}
def switchOffOneHandler(evt) {
	log.debug "switch off1"
	strip.off()
}
def switchOffTwoHandler(evt) {
	log.debug "switch off2"
	strip.off2()
}