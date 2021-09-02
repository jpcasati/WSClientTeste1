package com.example.wsclientteste1

import android.os.StrictMode
import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE
import org.xmlpull.v1.XmlPullParserException
import java.io.IOException


class ClientSaudacao {


    @Throws(IOException::class, XmlPullParserException::class)
    fun salvarCurso(c: Curso?): String? {
        val soap = SoapObject(
            "http://testewsaula1.casati.com.br/",
            "salvarcurso"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("curso", c)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/testewsaula1/Saudacao?wsdl"
        )

        transmitir.call("salvarcurso", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }




    @Throws(IOException::class, XmlPullParserException::class)
    fun salvarAluno(a: Aluno?): String? {
        val soap = SoapObject(
            "http://testewsaula1.casati.com.br/",
            "teste_objeto"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("objeto", a)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER10)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://10.0.2.2:8080/testewsaula1/Saudacao?wsdl"
        )

        transmitir.call("teste_objeto", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }







    @Throws(IOException::class, XmlPullParserException::class)
    fun receberSaudacao(valor: String?): String? {

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        val soap = SoapObject(
            "http://schemas.xmlsoap.org/soap/envelope/",
            "SOAWebServices/ConsultaCEP"
        )
        //SOAP OBJECT
        // namespace é o que está no targetnamespace do WSDL
        // name é o nome da operação (método) que irá executar

        // Parâmetros que o webservice recebe
        soap.addProperty("cep", valor)

        // Usado 1.1 (VER11) no Glassfish
        // Tomcat - VER10
        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER12)

        envelope.setOutputSoapObject(soap)

        val transmitir = HttpTransportSE(
            "http://www.soawebservices.com.br/webservices/producao/cep/cep.asmx?op=ConsultaCEP"
        )

        transmitir.call("SOAWebServices/ConsultaCEP", envelope)

        // Pego o resultado da execução do webservice
        val resultado = envelope.response

        return resultado.toString()
    }
}