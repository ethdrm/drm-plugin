package io.guthub.ethdrm.example.plugin.contract;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
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
public final class LicenceContainer extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b5b6105688061001c6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063818d4b5d1461005c578063beabacc8146100b3578063eac449d914610129578063f5d82b6b14610180575bfe5b341561006457fe5b610099600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506101d7565b604051808215151515815260200191505060405180910390f35b34156100bb57fe5b61010f600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610225565b604051808215151515815260200191505060405180910390f35b341561013157fe5b610166600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506103a7565b604051808215151515815260200191505060405180910390f35b341561018857fe5b6101bd600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610451565b604051808215151515815260200191505060405180910390f35b600081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101590505b92915050565b600081600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410806102f35750600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205401105b1561030157600090506103a0565b81600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550600190505b9392505050565b600081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410156103f9576000905061044b565b81600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540392505081905550600190505b92915050565b6000600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020540110156104e45760009050610536565b81600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550600190505b929150505600a165627a7a723058206c345688406272f10dc53ed0b5c7de3ce5aae0a33aa74469e9113d51f98d6ba90029";

    private LicenceContainer(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private LicenceContainer(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public Future<TransactionReceipt> owns(Address owner, Uint256 amount) {
        Function function = new Function("owns", Arrays.<Type>asList(owner, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> transfer(Address from, Address to, Uint256 amount) {
        Function function = new Function("transfer", Arrays.<Type>asList(from, to, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> revoke(Address from, Uint256 amount) {
        Function function = new Function("revoke", Arrays.<Type>asList(from, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> add(Address to, Uint256 amount) {
        Function function = new Function("add", Arrays.<Type>asList(to, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public static Future<LicenceContainer> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(LicenceContainer.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static Future<LicenceContainer> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue) {
        return deployAsync(LicenceContainer.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialValue);
    }

    public static LicenceContainer load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new LicenceContainer(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static LicenceContainer load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new LicenceContainer(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
