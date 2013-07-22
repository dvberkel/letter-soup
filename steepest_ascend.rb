#! /usr/bin/env ruby

class Alphabet
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
end

debug = true

alphabet = nil
File.open('alphabet.txt').each_line do |line|
  alphabet = Alphabet.new(line.chomp)
end

words = [];
File.open('words.txt').each_line do |line|
  words << line.chomp
end

increasing = words.select { |word| alphabet.increasing?(word) }
target = increasing.length

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

puts "#{best_candidate}"
