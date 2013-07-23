#! /usr/bin/env ruby

class Alphabet
  attr_reader :alphabet
  def initialize(alphabet)
    @alphabet = alphabet
  end

  def increasing?(word)
    for index in (0..(word.length-2)) do
      first = word.slice(index, 1).upcase
      second = word.slice(index + 1, 1).upcase
      if @alphabet.index(first) > @alphabet.index(second) then
        return false
      end
    end
    return true
  end

  def candidates(&block)
    length = @alphabet.length
    for index in (0..(length-2)) do
      candidate = @alphabet.slice(0..(index - 1)) +
                  @alphabet.slice(index, 2).reverse +
                  @alphabet.slice((index+2)..(length - 1))
      block.call(Alphabet.new(candidate))
    end
  end

  def to_s()
    @alphabet
  end

  def ==(other)
    @alphabet == other.alphabet
  end
end

debug = true
alphabet = Alphabet.new("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("").shuffle.join)

puts "[#{alphabet}]"

words = [];
File.open('words.txt').each_line do |line|
  words << line.chomp
end

begin
  increasing = words.select { |word| alphabet.increasing?(word) }
  target = increasing.length
  old_target = target

  best_candidate = alphabet
  alphabet.candidates do |candidate|
    increasing = words.select { |word| candidate.increasing?(word) }
    if increasing.length > target then
      best_candidate = candidate
      target = increasing.length
      if debug then
        puts best_candidate
        puts target
      end
    end
  end
  if target > old_target then
    alphabet = best_candidate
    if debug then
      puts ">#{alphabet}<"
    end
  end
end while target != old_target

puts ">>#{alphabet}<<"
