def statusStage(WEBLOGIC_CREDENTIAL_USR, WEBLOGIC_CREDENTIAL_PSW, urlWl, clusterWl, ServerWL1, ServerWL2=''){
    
    sh """
    touch statusServer.py
    echo 'connect("${WEBLOGIC_CREDENTIAL_USR}","${WEBLOGIC_CREDENTIAL_PSW}","${urlWl}")' >> statusServer.py
    echo 'state ("${clusterWl}","Cluster")' >> statusServer.py
    echo 'lista = []' >> statusServer.py
    echo "lista.append('${ServerWL1}')" >> statusServer.py
    echo "lista.append('${ServerWL2}')" >> statusServer.py
    echo 'print lista' >> statusServer.py
    echo "if '' in lista:" >> statusServer.py
    echo "lista.remove('')" >> statusServer.py
    echo 'for i in lista:' >> statusServer.py
    echo "cd('domainRuntime:/ServerLifeCycleRuntimes/' + i)" >> statusServer.py
    echo 'state = cmo.getState()' >> statusServer.py
    echo 'if(state != "RUNNING"):' >> statusServer.py
    echo 'disconnect()' >> statusServer.py
    """
}