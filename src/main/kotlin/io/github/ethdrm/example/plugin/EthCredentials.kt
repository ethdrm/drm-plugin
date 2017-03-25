package io.github.ethdrm.example.plugin

import org.web3j.crypto.Credentials
import org.web3j.crypto.WalletUtils
import java.io.File
import java.io.IOException

const val USER_HOME = "user.home"
const val DRM_DIR = "/.ethdrm/"

data class EthCredentials(val username: String, val password: String) {

    val ethCredentials: Credentials? by lazy {
        try { WalletUtils.loadCredentials(password, walletFile()) } catch (e : IOException) { null }
    }

    private fun walletFile() = File(System.getProperty(USER_HOME) + DRM_DIR + username)
}


// TODO
//    fun createWallet(): File {
//        val file = walletFile()
//
//        file.parentFile.mkdirs()
//        WalletUtils.generateLightNewWalletFile(password, file)
//
//        return file
//    }