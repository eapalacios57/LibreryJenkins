def statusStage(WEBLOGIC_CREDENTIAL_USR, WEBLOGIC_CREDENTIAL_PSW, urlWl, ServerWL1, ServerWL2=''){
    
    sh """
    touch statusServer.py
    echo 'connect("${WEBLOGIC_CREDENTIAL_USR}","${WEBLOGIC_CREDENTIAL_PSW}","${urlWl}")' >> statusServer.py
    echo 'lista = []' >> statusServer.py
    echo "lista.append('${ServerWL1}')" >> statusServer.py
    echo "lista.append('${ServerWL2}')" >> statusServer.py
    echo 'print lista' >> statusServer.py
    echo "if '' in lista:" >> statusServer.py
    echo " lista.remove('')" >> statusServer.py
    echo 'for i in lista:' >> statusServer.py
    echo " cd('domainRuntime:/ServerLifeCycleRuntimes/' + i)" >> statusServer.py
    echo ' stateServer = cmo.getState()' >> statusServer.py
    echo ' print " Status Server ------->>" + statusServer' >> statusServer.py
    echo ' cd("domainRuntime:/ServerRuntimes/" + i +"/ThreadPoolRuntime/ThreadPoolRuntime")' >> statusServer.py
    echo " detailServer = get('HealthState')" >> statusServer.py
    echo " healthServer = detailServer.toString().split(',')[2].split(':')[1].split('HEALTH_')[1]" >> statusServer.py
    echo ' print " Status Health Server ------->>" + healthServer' >> statusServer.py
    echo ' if(stateServer != "RUNNING" or healthServer != "OK"):' >> statusServer.py
    echo '  disconnect()' >> statusServer.py
    """
}
