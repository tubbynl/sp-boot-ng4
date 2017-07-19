package com.example.spbootng4.repository;

import com.example.spbootng4.entity.ObjectWithId;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Repository<T extends ObjectWithId> extends List<T> {

  default List<T> findAll() {
    return this;
  }

  default Stream<T> filter(Predicate<T> filter) {
    return stream().filter(filter);
  }

  default Optional<T> findAny(Predicate<T> filter) {
    return filter(filter).findAny();
  }

  default Optional<T> findById(Long id) {
    return findAny(i -> id!=null && id.equals(i.getId()));
  }

  default Optional<Long> maxId() {
    return stream().map(T::getId).max(Long::compareTo);
  }

  default boolean exists(Long id) {
    return findById(id).isPresent();
  }
  T save(final T instance);

  Optional<T> update(final T instance);

  default boolean delete(final Long id) {
    return findById(id).map(this::remove).orElse(false);
  }
}
