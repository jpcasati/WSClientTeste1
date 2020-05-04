package com.example.wsclientteste1

import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException


class ClientSaudacao {

    @Throws(IOException::class, XmlPullParserException::class)
    fun receberSaudacao(nome: String?): String? {
        val soap = SoapObject(
            "http://testewsaula1.casati.com.br/",
            "hello"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("name", nome)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/testewsaula1/Saudacao?wsdl"
        )

        transmitir.call("hello", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }
}