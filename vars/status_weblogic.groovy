def statusStage(WEBLOGIC_CREDENTIAL_USR, WEBLOGIC_CREDENTIAL_PSW, urlWl, serverWl1, serverWl2=''){
    
    sh """
    touch statusServer.py
    echo 'connect("${WEBLOGIC_CREDENTIAL_USR}","${WEBLOGIC_CREDENTIAL_PSW}","${urlWl}")' >> statusServer.py
    echo 'lista = []' >> statusServer.py
    echo "lista.append('${serverWl1}')" >> statusServer.py
    echo "lista.append('${serverWl2}')" >> statusServer.py
    echo "if '' in lista:" >> statusServer.py
    echo " lista.remove('')" >> statusServer.py
    echo 'for i in lista:' >> statusServer.py
    echo " cd('domainRuntime:/ServerLifeCycleRuntimes/' + i)" >> statusServer.py
    echo ' stateServer = cmo.getState()' >> statusServer.py
    echo ' print "<<---------------------------------------------------------------->>"' >> statusServer.py
    echo ' print " Status Server " + i + " <<----------" + stateServer + "---------->>"' >> statusServer.py
    echo ' print "<<---------------------------------------------------------------->>"' >> statusServer.py
    echo ' cd("domainRuntime:/ServerRuntimes/" + i +"/ThreadPoolRuntime/ThreadPoolRuntime")' >> statusServer.py
    echo " detailServer = get('HealthState')" >> statusServer.py
    echo " healthServer = detailServer.toString().split(',')[2].split(':')[1].split('HEALTH_')[1]" >> statusServer.py
    echo " arrayConfig = detailServer.toString().split(',')" >> statusServer.py
    echo " for config in arrayConfig:" >> statusServer.py
    echo "  if 'State' in i.split(':'):" >> statusServer.py
    echo "    healtStatus = config.split(':')[1].split('HEALTH_')[1]" >> statusServer.py
    echo ' print "<<------------------------------------------------------------------------>>"' >> statusServer.py
    echo ' print " Status Health Server " + i + " <<----------" + healtStatus + "---------->>"' >> statusServer.py
    echo ' print "<<------------------------------------------------------------------------>>"' >> statusServer.py
    echo ' if(stateServer != "RUNNING" or healtStatus != "OK"):' >> statusServer.py
    echo '  disconnect()' >> statusServer.py
    """
}
