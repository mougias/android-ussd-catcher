<h1>Android USSD Catcher</h1>

<p>This service will catch any USSD responses and rebroadcast them so you can receive them in your programs.</p>

<p>The boot-up receiver is required, as the service has to be launched when the phone boots, so that PhoneUtils will bind to it.  If at any time while the phone is up the service stops, or if you need to make changes to the code, the phone must be rebooted.</p>