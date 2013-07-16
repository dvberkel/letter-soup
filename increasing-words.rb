#! /usr/bin/env ruby

def increasing?(alphabet, word)
  for index in (0..(word.length-2)) do
    first = word[index].upcase
    second = word[index + 1].upcase
    if alphabet.index(first) > alphabet.index(second) then
      return false
    end
  end
  return true
end

alphabet = nil
File.open('alphabet.txt').each_line do |line|
  alphabet = line
end

ARGF.each do |word|
  if (increasing?(alphabet, word)) then
    puts word
  end
end
