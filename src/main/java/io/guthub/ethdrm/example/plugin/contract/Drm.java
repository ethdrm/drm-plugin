package io.guthub.ethdrm.example.plugin.contract;

import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * <p>Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use {@link org.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version 2.1.0.
 */
public final class Drm extends Contract {
    private static final String BINARY = "6060604052341561000c57fe5b6040516040806200210d833981016040528080519060200190919080519060200190919050505b5b33600060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b816004819055508060058190555061008c610148565b809050604051809103906000f08015156100a257fe5b600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506100ea610159565b809050604051809103906000f080151561010057fe5b600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505b505061016a565b60405161058480620018da83390190565b6040516102af8062001e5e83390190565b611760806200017a6000396000f300606060405236156100c3576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063178b8378146100d45780632f20f749146100f4578063340668f41461016d57806341c0e1b51461023c57806396fb72171461024e578063a035b1fe146102a5578063a2b40d19146102cb578063a9059cbb146102eb578063acb2ad6f14610322578063bf67677d14610348578063d80af2ec146103c1578063efb810b114610443578063f9f92be414610479575b34156100cb57fe5b6100d25b5b565b005b34156100dc57fe5b6100f260048080359060200190919050506104c7565b005b34156100fc57fe5b61016b600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610577565b005b61023a6004808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509190803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091905050610781565b005b341561024457fe5b61024c610cce565b005b341561025657fe5b61028b600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610d62565b604051808215151515815260200191505060405180910390f35b34156102ad57fe5b6102b5610ec8565b6040518082815260200191505060405180910390f35b34156102d357fe5b6102e96004808035906020019091905050610ece565b005b610320600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610f7e565b005b341561032a57fe5b6103326111b0565b6040518082815260200191505060405180910390f35b341561035057fe5b6103bf600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506111b6565b005b34156103c957fe5b610441600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061134f565b005b341561044b57fe5b610477600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611586565b005b341561048157fe5b6104ad600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091905050611714565b604051808215151515815260200191505060405180910390f35b6000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105265760006000fd5b6005549050816005819055507fac8d13f8c445d614898726a3e8c94776304ad684f6024c1c5d361d520c503c448183604051808381526020018281526020019250505060405180910390a15b5b5050565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156105d45760006000fd5b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16634420e486836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b151561068d57fe5b60325a03f1151561069a57fe5b5050507f9c3c82ea7c9796c5fa1832974405317b1c3da2e182268d5cdc66fde9adb341468282604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360008314610741575b8051825260208311156107415760208201915060208101905060208303925061071d565b505050905090810190601f16801561076d5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15b5b5050565b60006000600060008551875114151561079a5760006000fd5b60009350600092505b8551831015610849576001600088858151811015156107be57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161561081b5760006000fd5b600454868481518110151561082c57fe5b9060200190602002015102840193505b82806001019350506107a3565b600092505b8451831015610aa257600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663c2bc2efc86858151811015156108a357fe5b906020019060200201516000604051604001526040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050604060405180830381600087803b151561093057fe5b60325a03f1151561093d57fe5b5050506040518051906020018051905091509150801515610a94578173ffffffffffffffffffffffffffffffffffffffff166382aa91ec8589896000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808481526020018060200180602001838103835285818151815260200191508051906020019060200280838360008314610a07575b805182526020831115610a07576020820191506020810190506020830392506109e3565b505050905001838103825284818151815260200191508051906020019060200280838360008314610a57575b805182526020831115610a5757602082019150602081019050602083039250610a33565b50505090500195505050505050602060405180830381600087803b1515610a7a57fe5b60325a03f11515610a8757fe5b5050506040518051905093505b5b828060010193505061084e565b83341015610ab05760006000fd5b600092505b8651831015610be757600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663f5d82b6b8885815181101515610b0a57fe5b906020019060200201518886815181101515610b2257fe5b906020019060200201516000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1515610bb657fe5b60325a03f11515610bc357fe5b505050604051805190501515610bd95760006000fd5b5b8280600101935050610ab5565b7f8d5845a7070f8c49e54e7a84769ab2953b673e4bcf6c12f148cb63248d34f3cd8787604051808060200180602001838103835285818151815260200191508051906020019060200280838360008314610c60575b805182526020831115610c6057602082019150602081019050602083039250610c3c565b505050905001838103825284818151815260200191508051906020019060200280838360008314610cb0575b805182526020831115610cb057602082019150602081019050602083039250610c8c565b50505090500194505050505060405180910390a15b50505050505050565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415610d5f57600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16ff5b5b565b60006000600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663818d4b5d85856000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1515610e3057fe5b60325a03f11515610e3d57fe5b5050506040518051905090507f2cbd411f745823b2d1968e01c484ab81ff2820482e0053cfc631380ff6460cf1848483604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182151515158152602001935050505060405180910390a15b5092915050565b60045481565b6000600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610f2d5760006000fd5b6004549050816004819055507f8aa4fa52648a6d15edce8a179c792c86f3719d0cc3c572cf90f91948f0f2cb688183604051808381526020018281526020019250505060405180910390a15b5b5050565b806005540280341015610f915760006000fd5b600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff1615610fe95760006000fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663beabacc83385856000604051602001526040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15156110e757fe5b60325a03f115156110f457fe5b50505060405180519050151561110a5760006000fd5b7fcb2c33abfd84c31c67f0999e1c945f5a7860691f7d86f83eb39fd0026964f1c2338484604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001828152602001935050505060405180910390a15b5b505050565b60055481565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156112135760006000fd5b6001600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055507f8a6072dc26181a8faacaaaa37cbe92062c4d4f749710166b1c6e1d47b0212d1e8282604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200182810382528381815181526020019150805190602001908083836000831461130f575b80518252602083111561130f576020820191506020810190506020830392506112eb565b505050905090810190601f16801561133b5780820380516001836020036101000a031916815260200191505b50935050505060405180910390a15b5b5050565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156113ac5760006000fd5b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663eac449d984846000604051602001526040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b151561147657fe5b60325a03f1151561148357fe5b5050506040518051905015156114995760006000fd5b7f0f991ee2a38d83aea60bf2f0c45829f4ee148a01259e010876270b06615a6abd838383604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019080838360008314611544575b80518252602083111561154457602082019150602081019050602083039250611520565b505050905090810190601f1680156115705780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a15b5b505050565b600060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156115e35760006000fd5b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166384ac33ec826040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b151561169c57fe5b60325a03f115156116a957fe5b5050507ffc31d959dbf829f4c793dc1939ce98ee44ffbc16281ece47daaaea64270a716c81604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a15b5b50565b60016020528060005260406000206000915054906101000a900460ff16815600a165627a7a723058206d88e0d87a6a69a4eebaac0f1719be11a37c1290f220f53dac005fd99f33266f00296060604052341561000c57fe5b5b6105688061001c6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063818d4b5d1461005c578063beabacc8146100b3578063eac449d914610129578063f5d82b6b14610180575bfe5b341561006457fe5b610099600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506101d7565b604051808215151515815260200191505060405180910390f35b34156100bb57fe5b61010f600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610225565b604051808215151515815260200191505060405180910390f35b341561013157fe5b610166600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919080359060200190919050506103a7565b604051808215151515815260200191505060405180910390f35b341561018857fe5b6101bd600480803573ffffffffffffffffffffffffffffffffffffffff16906020019091908035906020019091905050610451565b604051808215151515815260200191505060405180910390f35b600081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054101590505b92915050565b600081600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410806102f35750600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205401105b1561030157600090506103a0565b81600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000828254039250508190555081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550600190505b9392505050565b600081600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410156103f9576000905061044b565b81600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540392505081905550600190505b92915050565b6000600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482600060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020540110156104e45760009050610536565b81600060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008282540192505081905550600190505b929150505600a165627a7a723058206c345688406272f10dc53ed0b5c7de3ce5aae0a33aa74469e9113d51f98d6ba900296060604052341561000c57fe5b5b6102938061001c6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680634420e4861461005157806384ac33ec14610087578063c2bc2efc146100bd575bfe5b341561005957fe5b610085600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061013e565b005b341561008f57fe5b6100bb600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061019a565b005b34156100c557fe5b6100f1600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506101f6565b604051808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001821515151581526020019250505060405180910390f35b6001600060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b50565b6000600060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055505b50565b60006000600060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff16151561025a576000600191509150610262565b826000915091505b9150915600a165627a7a723058204c81b63afc336226880237e0a6abbd93d39480471ad7d528af1566421457d2d80029";

    private Drm(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    private Drm(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<LicenceBoughtEventResponse> getLicenceBoughtEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LicenceBought", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<LicenceBoughtEventResponse> responses = new ArrayList<LicenceBoughtEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            LicenceBoughtEventResponse typedResponse = new LicenceBoughtEventResponse();
            typedResponse.to = (DynamicArray<Address>)eventValues.getNonIndexedValues().get(0);
            typedResponse.amount = (DynamicArray<Uint256>)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LicenceBoughtEventResponse> licenceBoughtEventObservable() {
        final Event event = new Event("LicenceBought", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LicenceBoughtEventResponse>() {
            @Override
            public LicenceBoughtEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LicenceBoughtEventResponse typedResponse = new LicenceBoughtEventResponse();
                typedResponse.to = (DynamicArray<Address>)eventValues.getNonIndexedValues().get(0);
                typedResponse.amount = (DynamicArray<Uint256>)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<LicenceTransferedEventResponse> getLicenceTransferedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LicenceTransfered", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<LicenceTransferedEventResponse> responses = new ArrayList<LicenceTransferedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            LicenceTransferedEventResponse typedResponse = new LicenceTransferedEventResponse();
            typedResponse.from = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.to = (Address)eventValues.getNonIndexedValues().get(1);
            typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LicenceTransferedEventResponse> licenceTransferedEventObservable() {
        final Event event = new Event("LicenceTransfered", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LicenceTransferedEventResponse>() {
            @Override
            public LicenceTransferedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LicenceTransferedEventResponse typedResponse = new LicenceTransferedEventResponse();
                typedResponse.from = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.to = (Address)eventValues.getNonIndexedValues().get(1);
                typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<LicenceRevokedEventResponse> getLicenceRevokedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("LicenceRevoked", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<LicenceRevokedEventResponse> responses = new ArrayList<LicenceRevokedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            LicenceRevokedEventResponse typedResponse = new LicenceRevokedEventResponse();
            typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
            typedResponse.reason = (Utf8String)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LicenceRevokedEventResponse> licenceRevokedEventObservable() {
        final Event event = new Event("LicenceRevoked", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, LicenceRevokedEventResponse>() {
            @Override
            public LicenceRevokedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                LicenceRevokedEventResponse typedResponse = new LicenceRevokedEventResponse();
                typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
                typedResponse.reason = (Utf8String)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public List<DiscountAddedEventResponse> getDiscountAddedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("DiscountAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<DiscountAddedEventResponse> responses = new ArrayList<DiscountAddedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            DiscountAddedEventResponse typedResponse = new DiscountAddedEventResponse();
            typedResponse.discount = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.description = (Utf8String)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DiscountAddedEventResponse> discountAddedEventObservable() {
        final Event event = new Event("DiscountAdded", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DiscountAddedEventResponse>() {
            @Override
            public DiscountAddedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DiscountAddedEventResponse typedResponse = new DiscountAddedEventResponse();
                typedResponse.discount = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.description = (Utf8String)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<DiscountRemovedEventResponse> getDiscountRemovedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("DiscountRemoved", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<DiscountRemovedEventResponse> responses = new ArrayList<DiscountRemovedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            DiscountRemovedEventResponse typedResponse = new DiscountRemovedEventResponse();
            typedResponse.discount = (Address)eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DiscountRemovedEventResponse> discountRemovedEventObservable() {
        final Event event = new Event("DiscountRemoved", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DiscountRemovedEventResponse>() {
            @Override
            public DiscountRemovedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DiscountRemovedEventResponse typedResponse = new DiscountRemovedEventResponse();
                typedResponse.discount = (Address)eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public List<CustomerBannedEventResponse> getCustomerBannedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("CustomerBanned", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<CustomerBannedEventResponse> responses = new ArrayList<CustomerBannedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            CustomerBannedEventResponse typedResponse = new CustomerBannedEventResponse();
            typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.reason = (Utf8String)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CustomerBannedEventResponse> customerBannedEventObservable() {
        final Event event = new Event("CustomerBanned", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CustomerBannedEventResponse>() {
            @Override
            public CustomerBannedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CustomerBannedEventResponse typedResponse = new CustomerBannedEventResponse();
                typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.reason = (Utf8String)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<PriceChangedEventResponse> getPriceChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("PriceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<PriceChangedEventResponse> responses = new ArrayList<PriceChangedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            PriceChangedEventResponse typedResponse = new PriceChangedEventResponse();
            typedResponse.oldPrice = (Uint256)eventValues.getNonIndexedValues().get(0);
            typedResponse.newPrice = (Uint256)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<PriceChangedEventResponse> priceChangedEventObservable() {
        final Event event = new Event("PriceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, PriceChangedEventResponse>() {
            @Override
            public PriceChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                PriceChangedEventResponse typedResponse = new PriceChangedEventResponse();
                typedResponse.oldPrice = (Uint256)eventValues.getNonIndexedValues().get(0);
                typedResponse.newPrice = (Uint256)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<TransferFeeChangedEventResponse> getTransferFeeChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TransferFeeChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<TransferFeeChangedEventResponse> responses = new ArrayList<TransferFeeChangedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            TransferFeeChangedEventResponse typedResponse = new TransferFeeChangedEventResponse();
            typedResponse.oldFee = (Uint256)eventValues.getNonIndexedValues().get(0);
            typedResponse.newFee = (Uint256)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferFeeChangedEventResponse> transferFeeChangedEventObservable() {
        final Event event = new Event("TransferFeeChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferFeeChangedEventResponse>() {
            @Override
            public TransferFeeChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TransferFeeChangedEventResponse typedResponse = new TransferFeeChangedEventResponse();
                typedResponse.oldFee = (Uint256)eventValues.getNonIndexedValues().get(0);
                typedResponse.newFee = (Uint256)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<DepositeReceivedEventResponse> getDepositeReceivedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("DepositeReceived", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<DepositeReceivedEventResponse> responses = new ArrayList<DepositeReceivedEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            DepositeReceivedEventResponse typedResponse = new DepositeReceivedEventResponse();
            typedResponse.sender = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DepositeReceivedEventResponse> depositeReceivedEventObservable() {
        final Event event = new Event("DepositeReceived", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, DepositeReceivedEventResponse>() {
            @Override
            public DepositeReceivedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                DepositeReceivedEventResponse typedResponse = new DepositeReceivedEventResponse();
                typedResponse.sender = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
                return typedResponse;
            }
        });
    }

    public List<HasLicenceEventResponse> getHasLicenceEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("HasLicence", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        List<EventValues> valueList = extractEventParameters(event,transactionReceipt);
        ArrayList<HasLicenceEventResponse> responses = new ArrayList<HasLicenceEventResponse>(valueList.size());
        for(EventValues eventValues : valueList) {
            HasLicenceEventResponse typedResponse = new HasLicenceEventResponse();
            typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
            typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
            typedResponse.status = (Bool)eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<HasLicenceEventResponse> hasLicenceEventObservable() {
        final Event event = new Event("HasLicence", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST,DefaultBlockParameterName.LATEST, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, HasLicenceEventResponse>() {
            @Override
            public HasLicenceEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                HasLicenceEventResponse typedResponse = new HasLicenceEventResponse();
                typedResponse.customer = (Address)eventValues.getNonIndexedValues().get(0);
                typedResponse.amount = (Uint256)eventValues.getNonIndexedValues().get(1);
                typedResponse.status = (Bool)eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> changeTransferFee(Uint256 newTransferFee) {
        Function function = new Function("changeTransferFee", Arrays.<Type>asList(newTransferFee), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> registerDiscount(Address discount, Utf8String description) {
        Function function = new Function("registerDiscount", Arrays.<Type>asList(discount, description), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> buy(DynamicArray<Address> to, DynamicArray<Uint256> amount, DynamicArray<Address> discounts) {
        Function function = new Function("buy", Arrays.<Type>asList(to, amount, discounts), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> kill() {
        Function function = new Function("kill", Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> check(Address customer, Uint256 amount) {
        Function function = new Function("check", Arrays.<Type>asList(customer, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> price() {
        Function function = new Function("price", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> changePrice(Uint256 newPrice) {
        Function function = new Function("changePrice", Arrays.<Type>asList(newPrice), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> transfer(Address to, Uint256 amount) {
        Function function = new Function("transfer", Arrays.<Type>asList(to, amount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Uint256> transferFee() {
        Function function = new Function("transferFee", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> ban(Address customer, Utf8String reason) {
        Function function = new Function("ban", Arrays.<Type>asList(customer, reason), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> revoke(Address from, Uint256 amount, Utf8String reason) {
        Function function = new Function("revoke", Arrays.<Type>asList(from, amount, reason), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<TransactionReceipt> deregisterDiscount(Address discount) {
        Function function = new Function("deregisterDiscount", Arrays.<Type>asList(discount), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public Future<Bool> blacklist(Address param0) {
        Function function = new Function("blacklist", 
                Arrays.<Type>asList(param0), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public static Future<Drm> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Uint256 startPrice, Uint256 startTransferFee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(startPrice, startTransferFee));
        return deployAsync(Drm.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Future<Drm> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialValue, Uint256 startPrice, Uint256 startTransferFee) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(startPrice, startTransferFee));
        return deployAsync(Drm.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialValue);
    }

    public static Drm load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Drm(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Drm load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Drm(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LicenceBoughtEventResponse {
        public DynamicArray<Address> to;

        public DynamicArray<Uint256> amount;
    }

    public static class LicenceTransferedEventResponse {
        public Address from;

        public Address to;

        public Uint256 amount;
    }

    public static class LicenceRevokedEventResponse {
        public Address customer;

        public Uint256 amount;

        public Utf8String reason;
    }

    public static class DiscountAddedEventResponse {
        public Address discount;

        public Utf8String description;
    }

    public static class DiscountRemovedEventResponse {
        public Address discount;
    }

    public static class CustomerBannedEventResponse {
        public Address customer;

        public Utf8String reason;
    }

    public static class PriceChangedEventResponse {
        public Uint256 oldPrice;

        public Uint256 newPrice;
    }

    public static class TransferFeeChangedEventResponse {
        public Uint256 oldFee;

        public Uint256 newFee;
    }

    public static class DepositeReceivedEventResponse {
        public Address sender;

        public Uint256 amount;
    }

    public static class HasLicenceEventResponse {
        public Address customer;

        public Uint256 amount;

        public Bool status;
    }
}
