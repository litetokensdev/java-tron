package org.tron.core.vm.repository;

import org.tron.common.runtime.vm.DataWord;
import org.tron.core.capsule.*;
import org.tron.core.store.*;
import org.tron.core.vm.program.Storage;
import org.tron.protos.Protocol;

public interface Repository {

  AssetIssueCapsule getAssetIssue(byte[] tokenId);

  AssetIssueV2Store getAssetIssueV2Store();

  AssetIssueStore getAssetIssueStore();

  DynamicPropertiesStore getDynamicPropertiesStore();

  DelegationStore getDelegationStore();

  WitnessStore getWitnessStore();

  AccountCapsule createAccount(byte[] address, Protocol.AccountType type);

  AccountCapsule createAccount(byte[] address, String accountName, Protocol.AccountType type);

  AccountCapsule getAccount(byte[] address);

    void saveDynamic(byte[] word, BytesCapsule bytesCapsule);

    BytesCapsule getDynamic(byte[] bytesKey);

  DelegatedResourceCapsule getDelegatedResource(byte[] key);

  DelegatedResourceAccountIndexCapsule getDelegatedResourceAccountIndex(byte[] address);

  VotesCapsule getVotesCapsule(byte[] address);

  long getBeginCycle(byte[] address);

  long getEndCycle(byte[] address);

  AccountCapsule getAccountVote(long cycle, byte[] address);

  BytesCapsule getDelegationCache(Key key);

  void deleteContract(byte[] address);

  void createContract(byte[] address, ContractCapsule contractCapsule);

  ContractCapsule getContract(byte[] address);

  void updateContract(byte[] address, ContractCapsule contractCapsule);

  void updateAccount(byte[] address, AccountCapsule accountCapsule);

  void updateDynamic(byte[] word, BytesCapsule bytesCapsule);

  void updateDelegatedResource(byte[] word, DelegatedResourceCapsule delegatedResourceCapsule);

  void updateDelegatedResourceAccountIndex(byte[] word, DelegatedResourceAccountIndexCapsule delegatedResourceAccountIndexCapsule);

  void updateVotesCapsule(byte[] word, VotesCapsule votesCapsule);

  void updateBeginCycle(byte[] word, long cycle);

  void updateEndCycle(byte[] word, long cycle);

  void updateAccountVote(byte[] word, long cycle, AccountCapsule accountCapsule);

  void upRemark(byte[] word, long cycle);

  void updateDelegation(byte[] word, BytesCapsule bytesCapsule);

  void updateLastWithdrawCycle(byte[] address, long cycle);

  void saveCode(byte[] address, byte[] code);

  byte[] getCode(byte[] address);

  void putStorageValue(byte[] address, DataWord key, DataWord value);

  DataWord getStorageValue(byte[] address, DataWord key);

  Storage getStorage(byte[] address);

  long getBalance(byte[] address);

  long addBalance(byte[] address, long value);

  Repository newRepositoryChild();

  void setParent(Repository deposit);

  void commit();

  void putAccount(Key key, Value value);

  void putCode(Key key, Value value);

  void putContract(Key key, Value value);

  void putStorage(Key key, Storage cache);

  void putAccountValue(byte[] address, AccountCapsule accountCapsule);

  void putDynamic(Key key, Value value);

  void putDelegatedResource(Key key, Value value);

  void putDelegatedResourceAccountIndex(Key key, Value value);

  void putVotesCapsule(Key key, Value value);

  void putAssetIssueValue(byte[] tokenId, AssetIssueCapsule assetIssueCapsule);

  long addTokenBalance(byte[] address, byte[] tokenId, long value);

  long getTokenBalance(byte[] address, byte[] tokenId);

  long getAccountLeftEnergyFromFreeze(AccountCapsule accountCapsule);

  long calculateGlobalEnergyLimit(AccountCapsule accountCapsule);

  byte[] getBlackHoleAddress();

  BlockCapsule getBlockByNum(final long num);

  AccountCapsule createNormalAccount(byte[] address);

  WitnessCapsule getWitnessCapsule(byte[] address);

  void saveTokenIdNum(long num);

  long getTokenIdNum();

  void addTotalNetWeight(long amount);

  void addTotalEnergyWeight(long amount);

  void saveTotalEnergyWeight(long totalEnergyWeight);

  long getTotalEnergyWeight();

  void saveTotalNetWeight(long totalNetWeight);

  long getTotalNetWeight();

  long getTotalEnergyCurrentLimit();
}
