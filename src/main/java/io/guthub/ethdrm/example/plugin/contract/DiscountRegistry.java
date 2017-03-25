package io.guthub.ethdrm.example.plugin.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Future;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.1.0.
 */
public final class DiscountRegistry extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b6102938061001c6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680634420e4861461005157806384ac33ec14610087578063c2bc2efc146100bd575bfe5b341561005957fe5b610085600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061013e565b005b341561008f57fe5b6100bb600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061019a565b005b34156100c557fe5b6100f1600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506101f6565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001821515151581526020019250505060405180910390f35b6001600060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b50565b6000600060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b50565b60006000600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16151561025a576000600191509150610262565b826000915091505b9150915600a165627a7a723058204c81b63afc336226880237e0a6abbd93d39480471ad7d528af1566421457d2d80029";

    private DiscountRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private DiscountRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> register(Address discount) {
        Function function = new Function("register", Arrays.<Type>asList(discount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> deregister(Address discount) {
        Function function = new Function("deregister", Arrays.<Type>asList(discount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> get(Address discountAddr) {
        Function function = new Function("get", Arrays.<Type>asList(discountAddr), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<DiscountRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(DiscountRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static Future<DiscountRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(DiscountRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static DiscountRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiscountRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DiscountRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DiscountRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
